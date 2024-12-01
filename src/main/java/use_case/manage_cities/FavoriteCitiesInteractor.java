package use_case.manage_cities;

import data_access.CityStorage;

import java.util.List;

public class FavoriteCitiesInteractor {
    private final CityStorage cityStorage;

    public FavoriteCitiesInteractor(CityStorage cityStorage) {
        this.cityStorage = cityStorage;
    }

    public List<String> getFavoriteCities() {
        return cityStorage.loadCities();
    }

    public boolean addFavoriteCity(String cityName) {
        List<String> cities = cityStorage.loadCities();
        if (!cities.contains(cityName)) {
            cities.add(cityName);
            cityStorage.saveCities(cities);
            return true;
        }
        return false;
    }

    public boolean removeFavoriteCity(String cityName) {
        List<String> cities = cityStorage.loadCities();
        if (cities.contains(cityName)) {
            cities.remove(cityName);
            cityStorage.saveCities(cities);
            return true;
        }
        return false;
    }

    public boolean isCityValid(String cityName) {
        return cityName != null && !cityName.trim().isEmpty();
    }
}
