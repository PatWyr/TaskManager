package Model;

import java.sql.*;

public class DAO {
    private final String url = "jdbc:postgresql://localhost/TaskManager?user=postgres&password=123";
    private Connection conn;

    public DAO() throws SQLException {
    }

    public void setConn() throws SQLException {
        conn = DriverManager.getConnection(url);
    }

    public void prepareDatabase() throws SQLException {

    }




}
