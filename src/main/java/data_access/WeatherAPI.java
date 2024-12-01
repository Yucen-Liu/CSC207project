package data_access;

import entity.WeatherData;

public interface WeatherAPI {
    WeatherData getWeather(String location);
}
