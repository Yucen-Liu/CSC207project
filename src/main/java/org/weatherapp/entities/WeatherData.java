package org.weatherapp.entities;

import org.json.JSONObject;
import org.weatherapp.data_access.APIAccessInterface;
import org.weatherapp.data_access.APIAccessObject;
import org.weatherapp.data_access.WeatherAPI;

import java.math.RoundingMode;
import java.text.DecimalFormat;

// Data model to store weather information
public class WeatherData {
    private APIAccessInterface apiAccess;
    private String location;
    private double temperature;
    private String condition;
    private int humidity;

    public WeatherData(String location){
        this.apiAccess = new APIAccessObject();

        //Rounding for temperature
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        this.location = location;
        JSONObject weatherData = apiAccess.getWeather(location);
        this.temperature = Double.parseDouble(df.format(weatherData.getJSONObject("main").
                getDouble("temp")-273.15));
        this.condition = weatherData.getJSONArray("weather").getJSONObject(0).getString("description");
        this.humidity = weatherData.getJSONObject("main").getInt("humidity");
    }

    // Getters and Setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
