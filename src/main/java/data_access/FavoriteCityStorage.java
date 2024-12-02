package data_access;

import java.util.List;
// this is good
/**
 * Interface for managing the storage of favorite cities for users.
 * Provides methods to add, remove, and retrieve a user's favorite cities.
 */
public interface FavoriteCityStorage {
    //very good here
    /**
     * Adds a city to the user's list of favorite cities.
     *
     * @param userId   The unique identifier of the user.
     * @param cityName The name of the city to be added to the favorites list.
     */
    void addFavoriteCity(String userId, String cityName);

    /**
     * Removes a city from the user's list of favorite cities.
     *
     * @param userId   The unique identifier of the user.
     * @param cityName The name of the city to be removed from the favorites list.
     */
    void removeFavoriteCity(String userId, String cityName);

    /**
     * Retrieves the list of favorite cities for a given user.
     *
     * @param userId The unique identifier of the user.
     * @return A list of city names that are marked as favorites by the user.
     */
    List<String> getFavoriteCities(String userId);
}
