package Model;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

public class EventManager implements EventActions<Event> {

    private static final EventManager eventManager = new EventManager();
    private EventManager() {
    }

    public static EventManager getInstance() {
        return eventManager;
    }

    private static final List<Event> eventList = new ArrayList<>();

    @Override
    public void addEvent(Event obj) {
        eventList.add(obj);
    }

    @Override
    public void deleteEvent(Event obj) {
        eventList.remove(obj);
    }

    @Override
    public void modifyEvent(Event obj) {

    }

    @Override
    public Event getEvent() {
        return null;
    }
}
