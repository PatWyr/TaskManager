package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class WeatherView {

    @FXML
    Button back;
    @FXML
    ImageView picture;
    @FXML
    Text temperature;


    @FXML
    public void back() {
        back.getScene().getWindow().hide();
    }


}
