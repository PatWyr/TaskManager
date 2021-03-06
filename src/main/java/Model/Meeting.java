package Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@EqualsAndHashCode
@Setter
@Getter
@ToString
public class Meeting extends Event {
    private String withWho;
    private String place;

    public Meeting(Date date, String title, String description, String withWho, String place, int user_id) {
        super(date, title, description, user_id);
        this.withWho = withWho;
        this.place = place;
    }
}
