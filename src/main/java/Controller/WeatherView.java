package Controller;

import Model.Weather;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;


public class WeatherView {

    @FXML
    Button back;
    @FXML
    ImageView picture;
    @FXML
    Text temperatureMax;
    @FXML
    Text temperatureMin;

    private Weather weather = new Weather();

    @FXML
    public void initialize() throws IOException {
        checkImage();
        temperatureMax.setText(String.valueOf(weather.getTemperature("Maximum")));
        temperatureMin.setText(String.valueOf(weather.getTemperature("Minimum")));
    }
    //TODO
    //check all kinds of weather on this api
    public void checkImage() throws IOException {
        String weatherType = weather.getWeatherType();
        if(weatherType.equals("Rain")) {
            picture.setImage(new Image("raindrop.jpg"));
        }
    }




    @FXML
    public void back() {
        back.getScene().getWindow().hide();
    }


}
