package org.weatherapp.data_access;

import org.json.JSONObject;

public interface APIAccessInterface {
    JSONObject getWeather(String city);
}
