package data_access;

import entity.City;
import org.json.JSONObject;

public interface CurWeatherInfo {
    City getCurWeather(String location);
}
