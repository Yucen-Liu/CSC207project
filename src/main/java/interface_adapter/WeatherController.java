package interface_adapter;

import entity.WeatherData;
import use_case.weather.FetchWeatherData;

public class WeatherController {
    private final FetchWeatherData fetchWeatherData;

    public WeatherController(FetchWeatherData fetchWeatherData) {
        this.fetchWeatherData = fetchWeatherData;
    }

    public WeatherData getWeather(String location) {
        return fetchWeatherData.fetchWeather(location);
    }
}
