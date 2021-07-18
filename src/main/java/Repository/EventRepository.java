package Repository;

import java.util.List;

public interface EventRepository<T> {

    void saveEvent(T obj);
    void deleteEvent();
    List<T> findEvent(int id);

}
