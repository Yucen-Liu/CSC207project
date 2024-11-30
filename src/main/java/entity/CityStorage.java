package entity;

import java.util.List;

/**
 * Cities saved by a user in the Weather System Program.
 */
public interface CityStorage {
    /**
     * Adds a new city at the end of the list of already saved cities, provided that it is not yet in the list.
     * @param city the new city that would be added at the end of the list of already saved cities,
     * provided that it is not yet in the list.
     */
    void addCity(City city);

    /**
     * Removes a city from the list of already saved cities, provided that it is in the list.
     * @param city the city that would be removed from the list of already saved cities, provided that it is in the list.
     */
    void removeCity(City city);

    /**
     * Returns the list of the saved cities.
     * @return the list of the saved cities.
     */
    List<City> getCities();
}



