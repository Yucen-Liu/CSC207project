package data_access;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class FavoriteCityStorageImpl implements FavoriteCityStorage {

    // Map to store user's favorite cities. Key is userId, value is the list of favorite cities.
    private final Map<String, List<String>> userFavorites;

    public FavoriteCityStorageImpl() {
        this.userFavorites = new HashMap<>();
    }

    @Override
    public void addFavoriteCity(String userId, String cityName) {
        userFavorites.putIfAbsent(userId, new ArrayList<>());
        if (!userFavorites.get(userId).contains(cityName)) {
            userFavorites.get(userId).add(cityName);
        }
    }

    @Override
    public void removeFavoriteCity(String userId, String cityName) {
        if (userFavorites.containsKey(userId)) {
            userFavorites.get(userId).remove(cityName);
        }
    }

    @Override
    public List<String> getFavoriteCities(String userId) {
        return userFavorites.getOrDefault(userId, new ArrayList<>());
    }
}
