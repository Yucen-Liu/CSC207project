package use_case.manage_cities;

import data_access.FavoriteCityStorage;
import java.util.List;

public class FavoriteCitiesInteractor {

    private final FavoriteCityStorage favoriteCityStorage;

    // Constructor that takes a FavoriteCityStorage implementation
    public FavoriteCitiesInteractor(FavoriteCityStorage favoriteCityStorage) {
        this.favoriteCityStorage = favoriteCityStorage;
    }

    /**
     * Add a city to the user's favorite list.
     * @param userId The ID of the user.
     * @param cityName The name of the city to be added.
     */
    public void addCityToFavorites(String userId, String cityName) {
        favoriteCityStorage.addFavoriteCity(userId, cityName);
    }

    /**
     * Remove a city from the user's favorite list.
     * @param userId The ID of the user.
     * @param cityName The name of the city to be removed.
     */
    public void removeCityFromFavorites(String userId, String cityName) {
        favoriteCityStorage.removeFavoriteCity(userId, cityName);
    }

    /**
     * Get the list of favorite cities for a user.
     * @param userId The ID of the user.
     * @return A list of favorite city names.
     */
    public List<String> getUserFavorites(String userId) {
        return favoriteCityStorage.getFavoriteCities(userId);
    }
}
