package data_access;

import java.util.List;

public interface FavoriteCityStorage {
    void addFavoriteCity(String userId, String cityName);
    void removeFavoriteCity(String userId, String cityName);
    List<String> getFavoriteCities(String userId);
}
