package org.weatherapp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

// Service class to fetch weather data (currently simulated)
public class WeatherService {

    private String location;
    private double temperature;
    private String condition;
    private int humidity;

    public WeatherService(){
        String apiKey = "a7053dadfa852680faa79393bbab3b4f";
        String city = "London";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        StringBuilder response = new StringBuilder();

        try {
            // Create URL object
            URL url = new URL(urlString);
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check if the request was successful
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 200
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                // Read the response
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(response);

        location = jsonObject.getString("main");
        temperature = jsonObject.getJSONObject("main").getDouble("temp");
        condition = jsonObject.getJSONArray("weather").getJSONObject(2).getString("description");
        humidity = jsonObject.getJSONObject("main").getInt("humidity");
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
