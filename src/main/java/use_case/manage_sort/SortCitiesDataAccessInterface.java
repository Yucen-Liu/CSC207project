package use_case.manage_sort;

import entity.City;

public interface SortCitiesDataAccessInterface {
    City getCurWeather(String cityName);
}
