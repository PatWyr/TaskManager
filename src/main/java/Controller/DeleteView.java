package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class DeleteView {

    private MenuView menuView;

    @FXML
    Button delete;
    @FXML
    Button back;
    @FXML
    ChoiceBox tasks;

    public DeleteView(MenuView menuView) {
        this.menuView = menuView;
    }

    @FXML
    public void initialize() {
        tasks.setItems(menuView.getItems().sorted());
    }

    @FXML
    public void deleteEvent() {
        System.out.println(tasks.getValue());
        menuView.getItems().remove(tasks.getValue());
    }

    @FXML
    public void backToMenu() {
        back.getScene().getWindow().hide();
    }


}
