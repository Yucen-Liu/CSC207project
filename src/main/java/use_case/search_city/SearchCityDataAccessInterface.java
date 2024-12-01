package use_case.search_city;

import entity.City;

/**
 * DAO for the SearchCity Use Case.
 */
public interface SearchCityDataAccessInterface {
    City getCurWeather(String location);
}