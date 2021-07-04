import Model.DAO;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DaoTest {
    private DAO dao;
    @Test
    public void daoConn() throws SQLException {
        dao = new DAO();
    }

    @Test
    public void addTest() throws SQLException {
        dao = new DAO();
        dao.addTask("Test","Test","Test","Test");
    }


    @Test
    public void deleteTest() throws SQLException {
        dao = new DAO();
        dao.clearAll();
    }
}
