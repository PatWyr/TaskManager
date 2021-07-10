package Model;

import java.sql.*;

public class DAO {
    private final String url = "jdbc:postgresql://localhost/TaskManager?user=postgres&password=123";
    private final Connection conn;
    private String sql;
    private PreparedStatement pst;
    private static  DAO dao;


    public static DAO getInstance() throws SQLException {
        if(dao == null) {
            dao = new DAO();
        }
        return dao;
    }

    private DAO() throws SQLException {
        conn = DriverManager.getConnection(url);
        if (conn != null) {
            DatabaseMetaData dm = conn.getMetaData();
            System.out.println("Connected!");
            System.out.println("Driver name: " + dm.getDriverName());
            System.out.println("Driver version: " + dm.getDriverVersion());
            System.out.println("Product name: " + dm.getDatabaseProductName());
            System.out.println("Product version: " + dm.getDatabaseProductVersion());
        }
    }

    public void addTask(String title,String Description,String Date,String Type) throws SQLException {
        String ask ="SELECT MAX(TaskID) FROM Tasks";
        Statement pst1 = conn.createStatement();
        ResultSet set = pst1.executeQuery(ask);
        int data = 0;
        while (set.next()) {
            data = set.getInt(1);
        }
        sql = "INSERT INTO Tasks (TaskID,Title,Description,Date,Type)"
                +"Values (?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1,data+1);
        pst.setString(2,title);
        pst.setString(3,Description);
        pst.setString(4,Date);
        pst.setString(5,Type);
        pst.executeUpdate();
    }

    public void clearAll() throws SQLException {
        sql = "DELETE FROM Tasks";
        pst = conn.prepareStatement(sql);
        pst.executeUpdate();
    }
    
    public boolean findUser(String passedLogin,String passedPassword) throws SQLException {
         String ask ="SELECT login,password FROM Persons";
         Statement pst1 = conn.createStatement();
         ResultSet set = pst1.executeQuery(ask);
         String login = "";
         String pass = "";
         while (set.next()) {                  
             login = set.getString(1);
             pass = set.getString(2);
             if(login.equals(passedLogin) && pass.equals(passedPassword)) {
                 return true;
             }
         }
         return false;
    }

    public void addUser(String firstName,String lastName,String login,String password,String email) throws SQLException {
        String ask ="SELECT MAX(id) FROM Persons";
        Statement pst1 = conn.createStatement();
        ResultSet set = pst1.executeQuery(ask);
        int data = 0;
        while (set.next()) {
            data = set.getInt(1);
        }
        sql = "INSERT INTO Persons (id,name,surname,login,password,email)"
                +"Values (?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1,data+1);
        pst.setString(2,firstName);
        pst.setString(3,lastName);
        pst.setString(4,login);
        pst.setString(5,password);
        pst.setString(6,email);
        pst.executeUpdate();
    }

    public boolean findLogin(String login) throws SQLException {
        String ask ="SELECT login FROM Persons";
        Statement pst1 = conn.createStatement();
        ResultSet set = pst1.executeQuery(ask);
        while (set.next()) {
            if(set.getString(1) == login) {
                return false;
            }
        }
        return true;
    }







}
