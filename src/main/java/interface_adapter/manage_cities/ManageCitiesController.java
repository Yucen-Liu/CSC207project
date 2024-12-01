package interface_adapter.manage_cities;

import use_case.manage_cities.FavoriteCitiesInteractor;
import java.util.List;

public class ManageCitiesController {
    private final FavoriteCitiesInteractor interactor;

    public ManageCitiesController(FavoriteCitiesInteractor interactor) {
        this.interactor = interactor;
    }

    public void addCityToFavorites(String userId, String cityName) {
        interactor.addCityToFavorites(userId, cityName);
    }

    public void removeCityFromFavorites(String userId, String cityName) {
        interactor.removeCityFromFavorites(userId, cityName);
    }

    public List<String> getUserFavorites(String userId) {
        return interactor.getUserFavorites(userId);
    }
}
