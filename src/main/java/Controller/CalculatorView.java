package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorView {
    private final Stage stage = new Stage();
    protected final Logger log = Logger.getLogger(getClass().getName());
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
    Button zero;
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
    private String number = "";
    private String all = "";
    private int tmp = 0;
    private String sign = "";
    private int size = 0;

    @FXML
    public void calculate(ActionEvent actionEvent) {
        number += ((Button)actionEvent.getSource()).getText();
        all += ((Button)actionEvent.getSource()).getText();
        log.log(Level.INFO,number);
        screen.setText(String.valueOf(all));
    }

    @FXML
    public void add(ActionEvent actionEvent) {
        tmp = Integer.parseInt(number);
        all += " + ";
        screen.setText(all);
        result += tmp;
        number = "";
        sign = "+";
    }

    @FXML
    public void subtraction() {
        size+=1;
        tmp = Integer.parseInt(number);
        all += " - ";
        screen.setText(all);
        if(size == 1) {
            result += tmp;
        } else {
            result -= tmp;
        }
        number = "";
        sign = "-";
    }

    @FXML
    public void multiplyOperation() {
        size += 1;
        tmp = Integer.parseInt(number);
        all += " * ";
        screen.setText(all);
        if(size == 1) {
            result += tmp;
        } else {
            result *= tmp;
        }
        number = "";
        sign = "*";
    }

    @FXML
    public void divideOperation() throws InterruptedException {
        size += 1;
        tmp = Integer.parseInt(number);
        all += " / ";
        screen.setText(all);
        if(size == 1) {
            result += tmp;
        } else {
            try {
                result /= tmp;
            } catch (ArithmeticException e){
                e.getStackTrace();
            } finally {
                screen.setText("Err");
            }
        }
        number = "";
        sign = "/";
    }



    @FXML
    public void sum(ActionEvent actionEvent) {
        if(sign.contains("+")){
            tmp = Integer.parseInt(number);
            result += tmp;
        } else if(sign.contains("-")){
            tmp = Integer.parseInt(number);
            result -= tmp;
        } else if(sign.contains("*")){
            tmp = Integer.parseInt(number);
            result *= tmp;
        } else if(sign.contains("/")){
            tmp = Integer.parseInt(number);
            result /= tmp;
        }
        screen.setText("= " + result);
        result = 0;
        sign = "";
    }


    @FXML
    public void initialize() {
        screen.setText(String.valueOf(result));
        number = "";
        size = 0;
    }

    @FXML
    public void reset(ActionEvent actionEvent) {
        result = 0;
        screen.setText(String.valueOf(result));
        number = "";
        size = 0;
        tmp = 0;
        all = "";
    }

    @FXML
    public void returnToMenu(ActionEvent actionEvent) throws IOException {
        returnButton.getScene().getWindow().hide();
    }




}
