package Model;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class EventManager implements EventActions<Event> {
    private List<Event> eventList = new ArrayList<>();

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
