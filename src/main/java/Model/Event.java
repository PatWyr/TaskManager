package Model;
import lombok.*;
import java.util.Date;
@EqualsAndHashCode
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Event {
    protected Date date;
    protected String title;
    protected String description;

    public Event(Date date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }
}
