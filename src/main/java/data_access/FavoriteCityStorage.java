package data_access;

import java.util.List;

public interface FavoriteCityStorage {

    /**
     * Add a city to the user's favorite list.
     * @param userId The ID of the user.
     * @param cityName The name of the city to be added.
     */
    void addFavoriteCity(String userId, String cityName);

    /**
     * Remove a city from the user's favorite list.
     * @param userId The ID of the user.
     * @param cityName The name of the city to be removed.
     */
    void removeFavoriteCity(String userId, String cityName);

    /**
     * Get the list of favorite cities for a user.
     * @param userId The ID of the user.
     * @return A list of favorite city names.
     */
    List<String> getFavoriteCities(String userId);
}
