package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class MenuView {
    private Stage stage = new Stage();

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
