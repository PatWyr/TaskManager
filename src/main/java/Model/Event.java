package Model;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@EqualsAndHashCode
@Setter
@Getter
@ToString
@NoArgsConstructor

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
    @Transient
    protected int user_id;

    public Event(Date date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }
}
