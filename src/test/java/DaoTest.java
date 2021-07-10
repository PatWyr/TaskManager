import Model.DAO;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.Assert.*;

public class DaoTest {
    private DAO dao;
    @Test
    public void daoConn() throws SQLException {
        dao = DAO.getInstance();
    }

    @Test
    public void addTest() throws SQLException {
        dao = DAO.getInstance();
        dao.addTask("Test","Test","Test","Test");
    }


    @Test
    public void deleteTest() throws SQLException {
        dao = DAO.getInstance();
        dao.clearAll();
    }

    @Test
    public void findTest() throws SQLException {
        dao =  DAO.getInstance();
        assertEquals(true,dao.findUser("TEST","TEST"));
        assertEquals(false,dao.findUser("TES2T","2TEST"));
    }
}
