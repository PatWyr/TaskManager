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
        boolean emailTest = Pattern.compile("[a-zA-Z0-9]{5,15}[@]{1}[a-zA-Z0-9]{2,8}.com").matcher(email.getText()).matches();
        boolean passwordTest = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}").matcher(password.getText()).matches();
        boolean loginTest = Pattern.compile(".{5,}").matcher(login.getText()).matches();
        if( passwordTest && emailTest && loginTest) {
            log.log(Level.INFO,"All correct");
        } else {
            log.log(Level.INFO,"Not all correct");
        }

    }



}
