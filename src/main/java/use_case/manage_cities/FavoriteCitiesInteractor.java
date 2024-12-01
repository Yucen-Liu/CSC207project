package use_case.manage_cities;

import data_access.FavoriteCityStorage;
import java.util.List;

public class FavoriteCitiesInteractor {
    private final FavoriteCityStorage favoriteCityStorage;

    public FavoriteCitiesInteractor(FavoriteCityStorage favoriteCityStorage) {
        this.favoriteCityStorage = favoriteCityStorage;
    }

    public void addCityToFavorites(String userId, String cityName) {
        favoriteCityStorage.addFavoriteCity(userId, cityName);
    }

    public void removeCityFromFavorites(String userId, String cityName) {
        favoriteCityStorage.removeFavoriteCity(userId, cityName);
    }

    public List<String> getUserFavorites(String userId) {
        return favoriteCityStorage.getFavoriteCities(userId);
    }
}
