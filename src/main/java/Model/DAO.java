package Model;

import java.sql.*;

public class DAO {
    private final String url = "jdbc:postgresql://localhost/TaskManager?user=postgres&password=123";
    private Connection conn;
    private String sql;
    private PreparedStatement pst;


    public DAO() throws SQLException {
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

    public void prepareDatabase() throws SQLException {
        //TODO
        //add if not exist
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







}
