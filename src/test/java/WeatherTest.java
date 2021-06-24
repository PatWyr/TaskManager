import Model.Weather;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WeatherTest {
    private Weather weather = new Weather();


    @Test
    public void getTest() throws IOException {
        System.out.println(weather.getWeather());
    }

}
