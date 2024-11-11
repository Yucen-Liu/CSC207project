package org.weatherapp;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Service class to fetch weather data (currently simulated)
public class WeatherService {
    private JSONObject information;

    public WeatherService(){
        information = new JSONObject();
    }

    // Method to get current weather for a location
    public WeatherData getCurrentWeather(String loc) {
        //Rounding for temperature
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        //Call API with actual city
        String apiKey = "a7053dadfa852680faa79393bbab3b4f";
        String city = loc;
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder().url(urlString).build();
        try {
            final Response response = client.newCall(request).execute();
            information = new JSONObject(response.body().string());
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }

        String location = information.getString("name");
        double temperature = information.getJSONObject("main").getDouble("temp");
        String condition = information.getJSONArray("weather").getJSONObject(0).getString("description");
        int humidity = information.getJSONObject("main").getInt("humidity");

        // Simulate fetching weather data
        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(location);
        weatherData.setTemperature(Double.parseDouble(df.format(temperature-273.15)));
        weatherData.setCondition(condition);
        weatherData.setHumidity(humidity);

        return weatherData;
    }
}
