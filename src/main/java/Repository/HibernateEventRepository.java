package Repository;
import Model.Event;
import com.sun.mail.util.LineInputStream;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateEventRepository implements EventRepository<Event> {

    @Override
    public void saveEvent(Event obj) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteEvent() {

    }

    @Override
    public List<Event> findEvent(int user_id) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final Query<Event> query = session.createQuery("from Event where user_id=:user_id", Event.class);
        query.setParameter("user_id", user_id);
       // final Event event = query.uniqueResult();
        List<Event> eventList = query.list();
        session.close();
        return eventList;
    }
}
