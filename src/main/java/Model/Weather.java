package Model;
import lombok.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Weather {
    private String API = "ix9H17wERuW9KYev92QbrVESOuMHbThQ";
    private OkHttpClient client;
    private Response response;

    public JSONObject getWeather() throws IOException {
        client = new OkHttpClient();
        Request request = new Request.Builder().url("http://dataservice.accuweather.com/forecasts/v1/daily/1day/274663?apikey=ix9H17wERuW9KYev92QbrVESOuMHbThQ").build();
        response = client.newCall(request).execute();
        assert response.body() != null;
        return new JSONObject(response.body().string());
    }

    public JSONArray getArray() throws IOException {
        return getWeather().getJSONArray("DailyForecasts");
    }

    public void getItems() throws IOException {
        for (int i = 0; i < getArray().length(); i++) {
            System.out.println(getArray().length());
            JSONObject post_id = getArray().getJSONObject(i).getJSONObject("Temperature").getJSONObject("Minimum");
            System.out.println(post_id);
        }
    }
    
    public int getTemperature(String type) throws IOException {
        int temperature = 0;
        if(type.equals("Minimum") || type.equals("Maximum")) {
            for (int i = 0; i < getArray().length(); i++) {
                temperature = getArray().getJSONObject(i).getJSONObject("Temperature").getJSONObject(type).getInt("Value");
            }
            return temperature;
        }
        return 0;

    }

    public String getWeatherType() throws IOException {
        String type = "";
        for (int i = 0; i < getArray().length(); i++) {
            type = getArray().getJSONObject(i).getJSONObject("Day").getString("PrecipitationType");
        }
        return type;
    }

}
