package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonCityStorageTest {
    private CityStorage storage;

    @BeforeEach
    void setUp() {
        storage = new CommonCityStorage();
    }

    @Test
    void testAddCity() {
        City city = new CommonCity("New York", 20.0, "Cloudy", 70);

        storage.addCity(city);
        List<City> cities = storage.getCities();

        assertEquals(1, cities.size());
        assertTrue(cities.contains(city));
    }

    @Test
    void testAddDuplicateCity() {
        City city = new CommonCity("New York", 20.0, "Cloudy", 70);

        storage.addCity(city);
        storage.addCity(city);
        List<City> cities = storage.getCities();

        assertEquals(1, cities.size());
    }

    @Test
    void testRemoveCity() {
        City city = new CommonCity("New York", 20.0, "Cloudy", 70);

        storage.addCity(city);
        storage.removeCity(city);
        List<City> cities = storage.getCities();

        assertEquals(0, cities.size());
        assertFalse(cities.contains(city));
    }
}
