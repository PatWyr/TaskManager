package Controller;

import Model.DAO;
import Model.PopUp;
import Model.User;
import Repository.HibernateUserRepository;
import Repository.UserRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


@Getter
@EqualsAndHashCode
@Setter
@ToString
public class LoginView {

    protected final Logger log = Logger.getLogger(getClass().getName());
    private final Stage stage = new Stage();
    private int errors = 0;
    private final DAO dao = DAO.getInstance();
    private final PopUp popUp = new PopUp();
    private final UserRepository repository = new HibernateUserRepository();
    private User user;

    @FXML
    TextArea login;
    @FXML
    PasswordField password;
    @FXML
    Button loginButton;
    @FXML
    Button register;


    public LoginView() throws SQLException {
    }



    @FXML
    public void logInSystem() throws SQLException, IOException {
        log.log(Level.INFO, "Logowanie");
        String tmpLogin = login.getText();
        String tmpPass = password.getText();
        //System.out.println("Login: " + tmpLogin);
        //System.out.println("Password: " + tmpPass);
        //dao.findUser(tmpLogin,tmpPass);
        user = repository.findUser(tmpLogin);
        if(user.getPassword().equals(tmpPass)){
            loginButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader((Objects.requireNonNull(getClass().getClassLoader().getResource("MenuView.fxml"))));
            loader.setControllerFactory(c -> {
                try {
                    return new MenuView(this);
                } catch (IOException throwables) {
                    throwables.printStackTrace();
                }
                return null;
            });
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 800);
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
        } else {
            errors++;
            if(errors == 3) {
                popUp.error();
                errors = 0;
            }
        }

    }

    @FXML
    public void registerNewAccount() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("RegisterView.fxml")));
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("RegisterCSS.css").toExternalForm());
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

}
