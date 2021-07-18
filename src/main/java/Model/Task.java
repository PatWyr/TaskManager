package Model;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@ToString
@EqualsAndHashCode

@Entity
@DiscriminatorValue("task")
public class Task extends Event {

private String category;

    public Task(Date date, String title, String description, String category,int user_id) {
        super(date, title, description,user_id);
        this.category = category;
    }

    public Task() {

    }
}
