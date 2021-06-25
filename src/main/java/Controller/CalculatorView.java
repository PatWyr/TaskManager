package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorView {
    private Stage stage = new Stage();

    @FXML
    Button returnButton;
    @FXML
    Button one;
    @FXML
    Button two;
    @FXML
    Button three;
    @FXML
    Button four;
    @FXML
    Button five;
    @FXML
    Button six;
    @FXML
    Button seven;
    @FXML
    Button eight;
    @FXML
    Button nine;
    @FXML
    Button plus;
    @FXML
    Button minus;
    @FXML
    Button C;
    @FXML
    Button multiply;
    @FXML
    Button divide;
    @FXML
    Button sumUp;
    @FXML
    TextArea screen = new TextArea();
    private float result = 0;


    public void calculate() {

    }

    @FXML
    public void initialize() {
        screen.setText(String.valueOf(result));
    }

    @FXML
    public void reset(ActionEvent actionEvent) {
        result = 0;
        screen.setText(String.valueOf(result));
    }

    @FXML
    public void returnToMenu(ActionEvent actionEvent) throws IOException {
        returnButton.getScene().getWindow().hide();
    }




}
