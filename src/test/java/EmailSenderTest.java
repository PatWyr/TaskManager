import Model.EmailSender;
import org.junit.jupiter.api.Test;

public class EmailSenderTest {

    private final EmailSender emailSender = new EmailSender();

    @Test
    public void sendTest() {
        emailSender.send();
    }

}
