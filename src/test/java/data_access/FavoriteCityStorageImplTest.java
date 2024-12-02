package data_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FavoriteCityStorageImplTest {
    private FavoriteCityStorageImpl storage;

    @BeforeEach
    void setUp() {
        storage = new FavoriteCityStorageImpl();
    }

    @Test
    void testAddFavoriteCity() {
        storage.addFavoriteCity("user1", "Toronto");
        List<String> favorites = storage.getFavoriteCities("user1");

        assertEquals(1, favorites.size());
        assertTrue(favorites.contains("Toronto"));
    }

    @Test
    void testRemoveFavoriteCity() {
        storage.addFavoriteCity("user1", "Toronto");
        storage.removeFavoriteCity("user1", "Toronto");

        List<String> favorites = storage.getFavoriteCities("user1");
        assertFalse(favorites.contains("Toronto"));
    }

    @Test
    void testGetFavoriteCities() {
        storage.addFavoriteCity("user1", "Toronto");
        storage.addFavoriteCity("user1", "Vancouver");

        List<String> favorites = storage.getFavoriteCities("user1");

        assertEquals(2, favorites.size());
        assertTrue(favorites.contains("Toronto"));
        assertTrue(favorites.contains("Vancouver"));
    }
}
