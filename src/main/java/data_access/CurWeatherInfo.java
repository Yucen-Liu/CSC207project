package data_access;

import entity.City;
import entity.CommonCity;

public interface CurWeatherInfo {
    /**
     * Retrieves the current weather information for a given location.
     *
     * @param location the name of the location
     * @return a City object containing current weather information
     */
    City getCurWeather(String location);

    /**
     * Checks if a city exists by its name.
     *
     * @param cityName the name of the city to validate
     * @return true if the city is valid, false otherwise
     */
    boolean existsByName(String cityName);
}
