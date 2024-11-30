package use_case.get_history;

import entity.City;

/**
 * DAO for the CityHistory Use Case.
 */
public interface GetHistoryDataAccessInterface {
    /**
     * Get the history weather information for a specific city.
     * @param count the number of timestamps we want to check on (three).
     */
    City getWeatherHistory(String location, int count);
}
