package Model;
import lombok.*;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return new JSONObject(response.body().string());
    }

    public JSONArray getArray() throws IOException {
        JSONArray weatherArr = getWeather().getJSONArray("DailyForecasts");
        return weatherArr;
    }

    public List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
    }

    public void getValue() throws IOException, ParseException {
        for (int i = 0; i < getArray().length(); ++i) {
            JSONObject rec = getArray().getJSONObject(i);
            System.out.println(rec.getJSONObject("Value"));

        }
    }


}
