package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginView {
    protected final Logger log = Logger.getLogger(getClass().getName());
    @FXML
    TextArea login;
    @FXML
    TextArea password;
    @FXML
    Button loginButton;

    @FXML
    public void logInSystem(){
        log.log(Level.INFO, "Logowanie");
        String tmpLogin = login.getText();
        String tmpPass = password.getText();
        System.out.println("Login: " + tmpLogin);
        System.out.println("Password: " + tmpPass);

    }

}
