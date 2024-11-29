package org.weatherapp.data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class WeatherAPI {
    private JSONObject information;
    private static final String API_KEY = "a7053dadfa852680faa79393bbab3b4f";

    // Method to get current weather for a location
    public JSONObject getWeatherInformation(String loc) {
        //Call API with actual city
        String city = loc;
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY;

        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder().url(urlString).build();
        try {
            final Response response = client.newCall(request).execute();
            information = new JSONObject(response.body().string());
        } catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
        return information;
    }
}
