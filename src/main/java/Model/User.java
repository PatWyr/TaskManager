package Model;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;


}
