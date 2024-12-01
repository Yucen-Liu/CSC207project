package data_access;

import java.util.List;

public interface CityStorage {
    /**
     * Load the list of cities.
     * @return A list of city names.
     */
    List<String> loadCities();

    /**
     * Save the list of cities.
     * @param cities A list of city names to save.
     */
    void saveCities(List<String> cities);

    /**
     * Add a single city to the storage.
     * @param city The city to add.
     * @return True if the city was added, false if it already exists.
     */
    boolean addCity(String city);

    /**
     * Remove a single city from the storage.
     * @param city The city to remove.
     * @return True if the city was removed, false if it does not exist.
     */
    boolean removeCity(String city);
}
