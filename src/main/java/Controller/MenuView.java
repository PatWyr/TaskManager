package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lombok.Getter;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Getter
public class MenuView {
    private static final MenuView menuView = new MenuView();

    public MenuView() {
    }

    public static MenuView getInstance() {
        return menuView;
    }

    private final Stage stage = new Stage();

    @FXML
    private Button task;
    @FXML
    private Button weather;
    @FXML
    private Button calculator;
    @FXML
    private MenuBar bar;
    @FXML
    private Menu logIn;
    @FXML
    private MenuItem user;
    @FXML
    private static ListView listView;

    @FXML
    public void initialize() {
    }

    public static void addItem(String title,String description,Date date, String category) {
        listView.getItems().add(title + " " + description + " " + date.toString() + " " + category);
    }



    @FXML
    public void login(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("LoginView.fxml")));
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void calculatorOpen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("CalculatorView.fxml")));
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("CalculatorCSS.css").toExternalForm());
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void addTask(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("TaskView.fxml")));
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Add Task");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}
