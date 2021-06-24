package Model;

public interface EventActions<T> {
    void addEvent(T obj);
    void deleteEvent(T obj);
    void modifyEvent(T obj);
    T getEvent();
}
