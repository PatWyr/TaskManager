package Controller;

import Model.EventManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;
import lombok.Getter;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Getter
public class MenuView {


    public MenuView() {
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
    private Button meeting;
    @FXML
    private ListView listView;

    private final ObservableList<String> items = FXCollections.observableArrayList();
    private final EventManager eventManager = EventManager.getInstance();

    @FXML
    public void initialize() {
        listView.setItems(items);
    }

    @FXML
    public void addItem(String title, String description, String date, String category) {
        listView.getItems().add(title + " " + description + " " + date + " " + category);
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
        FXMLLoader loader = new FXMLLoader((Objects.requireNonNull(getClass().getClassLoader().getResource("TaskView.fxml"))));
        loader.setControllerFactory(c -> {
            return new TaskView(this);
        });
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("TaskCSS.css").toExternalForm());
        stage.setTitle("Add Task");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void weatherOpen() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("WeatherView.fxml")));
        Scene scene = new Scene(root, 600, 600);
       // scene.getStylesheets().add(getClass().getClassLoader().getResource("CalculatorCSS.css").toExternalForm());
        stage.setTitle("Weather");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void addMeeting(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader((Objects.requireNonNull(getClass().getClassLoader().getResource("MeetingView.fxml"))));
        loader.setControllerFactory(c -> {
            return new MeetingView(this);
        });
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);
        //scene.getStylesheets().add(getClass().getClassLoader().getResource("TaskCSS.css").toExternalForm());
        stage.setTitle("Add Meeting");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}
