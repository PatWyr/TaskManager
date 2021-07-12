package Repository;
import Model.Event;
import org.hibernate.Session;

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
    public Event findEvent() {
        return null;
    }
}
