package Model;
import lombok.*;

import java.util.Date;


@Setter
@Getter
@ToString
public class Task extends Event {

private String category;

    public Task(Date date, String title, String description, String category) {
        super(date, title, description);
        this.category = category;
    }
}
