package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

public class RegisterView {

    private final Logger log = Logger.getLogger(getClass().getName());

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


    public void registerUser() {
        log.log(Level.INFO,"Registering new User");
        boolean emailTest=Pattern.compile(".s").matcher("as").matches();

    }



}
