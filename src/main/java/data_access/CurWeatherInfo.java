package data_access;

import org.json.JSONObject;

public interface CurWeatherInfo {
    JSONObject getCurWeather(String location);
}
