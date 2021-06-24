import Model.DAO;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DaoTest {
    @Test
    public void daoConn() throws SQLException {
        DAO dao = new DAO();
        dao.setConn();
    }
}
