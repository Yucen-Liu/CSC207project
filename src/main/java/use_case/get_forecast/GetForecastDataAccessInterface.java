package use_case.get_forecast;

import entity.ForecastCity;

/**
 * DAO for the CityHistory Use Case.
 */
public interface GetForecastDataAccessInterface {
    /**
     * Get the history weather information for a specific city.
     * @param count the number of timestamps we want to check on (three).
     */
    ForecastCity getWeatherForecast(String location, int count);
}
