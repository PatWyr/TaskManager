import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
          Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("LoginView.fxml")));
          Scene scene = new Scene(root, 400, 400);
          stage.setTitle("Login");
          stage.setScene(scene);
          stage.show();
    }
}
