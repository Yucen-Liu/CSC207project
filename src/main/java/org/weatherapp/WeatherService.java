package org.weatherapp;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JFrame;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import use_case.check_city.CheckCityDataAccessInterface;

// Service class to fetch weather data (currently simulated)
public class WeatherService implements CheckCityDataAccessInterface {
    private JSONObject information;

    public WeatherService() {
        information = new JSONObject();
    }

    // Method to get current weather for a location
    public WeatherData getCurrentWeather(String loc) {
        // Rounding for temperature
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        // Validate the city
        if (!CityValidator.isCityValid(loc)) {
            MessageBox.showWarningNoLoc(new JFrame());
            return null;
        }

        // Call API with the validated city
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + loc + "&appid=a7053dadfa852680faa79393bbab3b4f";

        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder().url(urlString).build();
        try {
            final Response response = client.newCall(request).execute();
            information = new JSONObject(response.body().string());
        } catch (Exception e) {
            MessageBox.showWarningNoLoc(new JFrame());
            return null;
        }

        try {
            String location = information.getString("name");
            double temperature = information.getJSONObject("main").getDouble("temp");
            String condition = information.getJSONArray("weather").getJSONObject(0).getString("description");
            int humidity = information.getJSONObject("main").getInt("humidity");

            // Populate weather data
            WeatherData weatherData = new WeatherData();
            weatherData.setLocation(location);
            weatherData.setTemperature(Double.parseDouble(df.format(temperature - 273.15)));
            weatherData.setCondition(condition);
            weatherData.setHumidity(humidity);

            return weatherData;
        } catch (Exception e) {
            MessageBox.showWarningNoLoc(new JFrame());
            return null;
        }
    }

    @Override
    public boolean existsByName(String cityName) {
        WeatherService weatherService = new WeatherService();
        return weatherService.getCurrentWeather(cityName) == null;
    }
}
