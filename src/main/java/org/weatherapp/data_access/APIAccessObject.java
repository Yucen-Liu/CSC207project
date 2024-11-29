package org.weatherapp.data_access;

import org.json.JSONObject;

public class APIAccessObject implements APIAccessInterface{
    private WeatherAPI weatherAPI;

    public JSONObject getWeather(String city) {
        this.weatherAPI = new WeatherAPI();
        return weatherAPI.getWeatherInformation(city);
    }
}
