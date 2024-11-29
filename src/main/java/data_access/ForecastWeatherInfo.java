package data_access;

import entity.City;
import org.json.JSONObject;

public interface ForecastWeatherInfo {
    City getForecastWeather(String location, int count);
}
