import Model.EventManager;
import Model.Task;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TaskManagerTest {

    private final EventManager eventManager = EventManager.getInstance();

    @Test
    public void createTask() {
        eventManager.addEvent(new Task(null,"Test","Test","Test"));
        assertEquals(eventManager.getEventList().size(),1);
        for(int i = 0;i < 10;i++) {
            eventManager.addEvent(new Task(null,"Test","Test","Test"));
        }
        assertEquals(eventManager.getEventList().size(),11);
        Task test = new Task(null,"Test","Test","Test");
        eventManager.addEvent(test);
        assertEquals(eventManager.getEventList().size(),12);
        eventManager.deleteEvent(test);
        assertEquals(eventManager.getEventList().size(),11);

    }

}
