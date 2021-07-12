package Repository;
import Model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final Query<User> query = session.createQuery("from User where login=:login", User.class);
        query.setParameter("login", login);
        final User user = query.uniqueResult();
        session.close();
        return user;
    }
}
