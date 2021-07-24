package Controller;

import Model.EmailSender;
import Model.Event;
import Model.EventManager;
import Model.User;
import Repository.EventRepository;
import Repository.HibernateEventRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
public class MenuView {


    private final Stage stage = new Stage();
    private ObservableList<String> items = FXCollections.observableArrayList();
    private final EventManager eventManager = EventManager.getInstance();
    private final EmailSender emailSender = new EmailSender();
    private final HibernateEventRepository eventRepository = new HibernateEventRepository();
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
    @FXML
    private Text name;
    private LoginView loginView;
    private User userInMenu;
    public MenuView() throws IOException {

    }
    public MenuView(LoginView loginView) throws IOException {
        this.loginView = loginView;
    }

    public ObservableList convert() {
        final EventRepository repository = new HibernateEventRepository();
        List<Event> eventList = repository.findEvent(userInMenu.getUser_id());
        ObservableList<String> convert = FXCollections.observableArrayList();
        String newEvent = "";
        for (Event event : eventList) {
            newEvent = event.getTitle() + " " + event.getDescription() + " "  +
                    event.getDate() + " ";
            convert.add(newEvent);
            newEvent = "";
        }
        return convert;
    }


    @FXML
    public void initialize() throws IOException {
        userInMenu = loginView.getUser();
        items = convert();
        listView.setItems(items);
        //emailSender.start();
        name.setText(userInMenu.getName());
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
            try {
                return new TaskView(this);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return null;
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
        scene.getStylesheets().add(getClass().getClassLoader().getResource("WeatherCSS.css").toExternalForm());
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
        scene.getStylesheets().add(getClass().getClassLoader().getResource("TaskCSS.css").toExternalForm());
        stage.setTitle("Add Meeting");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void deleteEvent() throws IOException {
        FXMLLoader loader = new FXMLLoader((Objects.requireNonNull(getClass().getClassLoader().getResource("DeleteView.fxml"))));
        loader.setControllerFactory(c -> {
            return new DeleteView(this);
        });
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);
        //scene.getStylesheets().add(getClass().getClassLoader().getResource("TaskCSS.css").toExternalForm());
        stage.setTitle("Delete");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}
