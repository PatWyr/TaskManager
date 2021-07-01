import Model.Weather;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WeatherTest {
    private final Weather weather = new Weather();


    @Test
    public void getTest() throws IOException, ParseException {
        weather.getValue();

    }

}
