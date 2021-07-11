package Repository;
import Model.User;
import org.hibernate.Session;

public class HibernateUserRepository implements UserRepository {

    @Override
    public void saveUser(User user) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public User findUser(String login) {
        return null;
    }
}
