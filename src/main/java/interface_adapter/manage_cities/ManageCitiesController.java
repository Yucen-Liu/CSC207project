package interface_adapter.manage_cities;

import use_case.manage_cities.FavoriteCitiesInteractor;
import java.util.List;

public class ManageCitiesController {

    private final FavoriteCitiesInteractor favoriteCitiesInteractor;

    // Constructor to initialize the FavoriteCitiesInteractor
    public ManageCitiesController(FavoriteCitiesInteractor favoriteCitiesInteractor) {
        this.favoriteCitiesInteractor = favoriteCitiesInteractor;
    }

    /**
     * Add a city to the user's favorite list.
     * @param userId The ID of the user.
     * @param cityName The name of the city to be added.
     */
    public void addCityToFavorites(String userId, String cityName) {
        favoriteCitiesInteractor.addCityToFavorites(userId, cityName);
    }

    /**
     * Remove a city from the user's favorite list.
     * @param userId The ID of the user.
     * @param cityName The name of the city to be removed.
     */
    public void removeCityFromFavorites(String userId, String cityName) {
        favoriteCitiesInteractor.removeCityFromFavorites(userId, cityName);
    }

    /**
     * Get the list of favorite cities for a user.
     * @param userId The ID of the user.
     * @return A list of favorite city names.
     */
    public List<String> getUserFavorites(String userId) {
        return favoriteCitiesInteractor.getUserFavorites(userId);
    }
}
