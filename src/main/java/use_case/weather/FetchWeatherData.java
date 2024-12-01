package use_case.weather;

import entity.WeatherData;
import data_access.WeatherAPI;

public class FetchWeatherData {
    private final WeatherAPI weatherAPI;

    public FetchWeatherData(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    public WeatherData fetchWeather(String location) {
        return weatherAPI.getWeather(location);
    }
}
