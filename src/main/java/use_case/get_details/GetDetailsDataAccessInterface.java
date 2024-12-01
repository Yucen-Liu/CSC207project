package use_case.get_details;

import entity.DetailedCity;
import entity.ForecastCity;

public interface GetDetailsDataAccessInterface {
    /**
     * Get the history weather information for a specific city.
     * @param location the name of the city we want to check on.
     */
    DetailedCity getDetailedWeather(String location);
}
