package Repository;

public interface EventRepository<T> {

    void saveEvent(T obj);
    void deleteEvent();
    T findEvent();

}
