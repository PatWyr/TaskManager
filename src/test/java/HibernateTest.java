import Model.Event;
import Model.User;
import Repository.EventRepository;
import Repository.HibernateEventRepository;
import Repository.HibernateUserRepository;
import Repository.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class HibernateTest {

    private final HibernateEventRepository eventRepository = new HibernateEventRepository();

    @Test
    public void saveTest() {
        final UserRepository repository = new HibernateUserRepository();
        repository.saveUser(new User("Patryk","W","TEST","TEST","TEST"));
    }
    @Test
    public void getTest() {
        final EventRepository repository = new HibernateEventRepository();
        List<Event> eventList = repository.findEvent(7);
        for (Event event : eventList) {
            System.out.println(event.getTitle());
        }
    }

    @Test
    public void converter() {
        ObservableList<String> items = FXCollections.observableArrayList();
        final EventRepository repository = new HibernateEventRepository();
        List<Event> eventList = repository.findEvent(7);
        String newEvent = "";
        for (Event event : eventList) {
            newEvent = event.getTitle() + " " + event.getDescription() + " "  +
                    event.getDate() + " ";
            items.add(newEvent);
            newEvent = "";
        }

        System.out.println(items);

    }

}
