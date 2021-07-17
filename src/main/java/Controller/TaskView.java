package Controller;
import Model.DAO;
import Model.Event;
import Model.EventManager;
import Model.Task;
import Repository.HibernateEventRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskView {

    private final Logger log = Logger.getLogger(getClass().getName());
    private final HibernateEventRepository eventRepository = new HibernateEventRepository();

    @FXML
    TextArea description;
    @FXML
    TextArea title;
    @FXML
    DatePicker date;
    @FXML
    ComboBox category;
    @FXML
    Button add;
    EventManager eventManager = EventManager.getInstance();

    private final MenuView menuView;
    private final DAO dao = DAO.getInstance();

    public TaskView(MenuView menuView) throws SQLException {
        this.menuView = menuView;
    }

    @FXML
    public void addTask() throws IOException, SQLException {
        LocalDate localDate = date.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        System.out.println(menuView.getUserInMenu().getUser_id());
        eventManager.addEvent(new Task(date,title.getText(),description.getText(), (String) category.getSelectionModel().getSelectedItem()));
        menuView.addItem(title.getText(),description.getText(),date.toString(),(String) category.getSelectionModel().getSelectedItem());
        eventRepository.saveEvent(new Task(date,title.getText(),description.getText(),(String) category.getSelectionModel().getSelectedItem()));
        //dao.addTask(title.getText(),description.getText(),date.toString(),(String) category.getSelectionModel().getSelectedItem());
        log.log(Level.INFO,"Task added");
        add.getScene().getWindow().hide();
    }



}
