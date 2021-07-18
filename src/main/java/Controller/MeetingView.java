package Controller;

import Model.EventManager;
import Model.Task;
import Repository.EventRepository;
import Repository.HibernateEventRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class MeetingView {

    private final MenuView menuView;
    private final EventManager eventManager = EventManager.getInstance();
    private final EventRepository eventRepository = new HibernateEventRepository();

    @FXML
    Button add;
    @FXML
    CheckBox checkbox;
    @FXML
    TextArea description;
    @FXML
    DatePicker date;
    @FXML
    TextArea title;


    public MeetingView(MenuView menuView) {
        this.menuView = menuView;
    }

    @FXML
    public void addMeeting() {
        LocalDate localDate = date.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        System.out.println(menuView.getUserInMenu().getUser_id());
        eventManager.addEvent(new Task(date, title.getText(), description.getText(), " - ", menuView.getUserInMenu().getUser_id()));
        menuView.addItem(title.getText(), description.getText(), date.toString(), (String) " - ");
        eventRepository.saveEvent(new Task(date, title.getText(), description.getText(), (String) " - ", menuView.getUserInMenu().getUser_id()));
        //dao.addTask(title.getText(),description.getText(),date.toString(),(String) category.getSelectionModel().getSelectedItem());
        add.getScene().getWindow().hide();
    }
}
