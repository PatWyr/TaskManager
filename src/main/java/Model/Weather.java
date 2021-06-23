package Model;
import netscape.javascript.JSObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;


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

    public JSONObject getMaxTemp() throws IOException {
        JSONObject maxTemp = getWeather().getJSONObject("Maximum");
        return maxTemp;
    }

}
