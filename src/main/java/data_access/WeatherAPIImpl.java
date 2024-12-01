package data_access;

import entity.WeatherData;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class WeatherAPIImpl implements WeatherAPI {
    private static final String API_KEY = "a7053dadfa852680faa79393bbab3b4f";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    @Override
    public WeatherData getWeather(String location) {
        String urlString = String.format("%s?q=%s&appid=%s", BASE_URL, location, API_KEY);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(urlString).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) {
                return null;
            }

            String responseBody = response.body().string();
            return parseWeatherData(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private WeatherData parseWeatherData(String responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody);

            // Parse necessary fields from the JSON response
            String location = jsonObject.getString("name");
            double temperature = jsonObject.getJSONObject("main").getDouble("temp") - 273.15; // Convert from Kelvin to Celsius
            String condition = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
            int humidity = jsonObject.getJSONObject("main").getInt("humidity");

            // Populate and return the WeatherData object
            WeatherData weatherData = new WeatherData();
            weatherData.setLocation(location);
            weatherData.setTemperature(temperature);
            weatherData.setCondition(condition);
            weatherData.setHumidity(humidity);

            return weatherData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
