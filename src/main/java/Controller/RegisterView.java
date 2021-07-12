package Controller;

import Model.DAO;
import Model.User;
import Repository.HibernateUserRepository;
import Repository.UserRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RegisterView {

    private final Logger log = Logger.getLogger(getClass().getName());
    private DAO dao = DAO.getInstance();
    private final UserRepository repository = new HibernateUserRepository();

    @FXML
    TextArea firstName;
    @FXML
    TextArea lastName;
    @FXML
    TextArea login;
    @FXML
    PasswordField password;
    @FXML
    TextArea email;
    @FXML
    Button register;

    public RegisterView() throws SQLException {
    }

    public void registerUser() throws SQLException {
        log.log(Level.INFO,"Registering new User");
        boolean emailTest = Pattern.compile("[a-zA-Z0-9]{5,15}[@]{1}[a-zA-Z0-9]{2,8}.com")
                .matcher(email.getText()).matches();
        boolean passwordTest = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}")
                .matcher(password.getText()).matches();
        if( passwordTest && emailTest && dao.findLogin(login.getText())) {
            log.log(Level.INFO,"All correct");
            repository.saveUser(new User(firstName.getText(),lastName.getText(),login.getText(),password.getText(),email.getText()));
            //dao.addUser(firstName.getText(),lastName.getText(),login.getText(),password.getText(),email.getText());
            register.getScene().getWindow().hide();
        } else {
            log.log(Level.INFO,"Not all correct");
        }
    }
}
