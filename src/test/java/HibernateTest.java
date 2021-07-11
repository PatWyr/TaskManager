import Model.User;
import Repository.HibernateUserRepository;
import Repository.UserRepository;
import org.junit.jupiter.api.Test;

public class HibernateTest {

    @Test
    public void saveTest() {
        final UserRepository repository = new HibernateUserRepository();
        repository.saveUser(new User("Patryk","W","TEST","TEST","TEST"));
    }
}
