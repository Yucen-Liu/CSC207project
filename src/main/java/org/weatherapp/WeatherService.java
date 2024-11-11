package org.weatherapp;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Service class to fetch weather data (currently simulated)
public class WeatherService {

    private String location;
    private double temperature;
    private String condition;
    private int humidity;
    private JSONObject information;

    public WeatherService(){
        String apiKey = "a7053dadfa852680faa79393bbab3b4f";
        String city = "London";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder().url(urlString).build();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            information = responseBody;
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }

        location = information.getString("name");
        temperature = information.getJSONObject("main").getDouble("temp");
        condition = information.getJSONArray("weather").getJSONObject(0).getString("description");
        humidity = information.getJSONObject("main").getInt("humidity");
    }

    // Method to get current weather for a location
    public WeatherData getCurrentWeather(String location) {
        // Simulate fetching weather data
        // TODO: Implement API calls here
        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(this.location);
        weatherData.setTemperature(temperature);
        weatherData.setCondition(condition);
        weatherData.setHumidity(humidity);

        return weatherData;
    }
}
