import Model.Weather;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class WeatherTest {
    private final Weather weather = new Weather();


    @Test
    public void getTest() throws IOException, ParseException {
        System.out.println(weather.getArray());
        weather.getItems();
    }

    @Test
    public void getValueTest() throws IOException {
        int testMin = weather.getTemperature("Minimum");
        int testMax = weather.getTemperature("Minimum");
        int error = weather.getTemperature("err");
        boolean flag = false;
        Assertions.assertEquals(0,error);
        if(testMin <= testMax) {
            flag = true;
        }
        Assertions.assertTrue(flag);
    }

    @Test
    public void getWeatherType() throws IOException {
        String result = weather.getWeatherType();
        System.out.println(result);
    }


}
