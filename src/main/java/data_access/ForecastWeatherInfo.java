package data_access;

import org.json.JSONObject;

public interface ForecastWeatherInfo {
    JSONObject getForecastWeather(String location);
}
