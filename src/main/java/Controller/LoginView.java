package Controller;

import Model.DAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginView {
    protected final Logger log = Logger.getLogger(getClass().getName());
    private Stage stage = new Stage();
    @FXML
    TextArea login;
    @FXML
    TextArea password;
    @FXML
    Button loginButton;

    private DAO dao = new DAO();

    public LoginView() throws SQLException {
    }

    @FXML
    public void logInSystem() throws SQLException, IOException {
        log.log(Level.INFO, "Logowanie");
        String tmpLogin = login.getText();
        String tmpPass = password.getText();
        System.out.println("Login: " + tmpLogin);
        System.out.println("Password: " + tmpPass);
        dao.findUser(tmpLogin,tmpPass);
        if(dao.findUser(tmpLogin,tmpPass)){
            loginButton.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("MenuView.fxml")));
            Scene scene = new Scene(root, 800, 800);
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
        }

    }

}
