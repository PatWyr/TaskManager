package Model;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "Events")
@DiscriminatorColumn(name = "discriminator")

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int event_id;
    @Column(name = "date")
    protected Date date;
    @Column(name = "title")
    protected String title;
    @Column(name = "description")
    protected String description;
    protected int user_id;

    public Event(Date date, String title, String description,int user_id) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event_id=" + event_id +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
