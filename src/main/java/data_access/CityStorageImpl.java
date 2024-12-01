package data_access;

import java.util.ArrayList;
import java.util.List;

public class CityStorageImpl implements CityStorage {
    private final List<String> cities;

    public CityStorageImpl() {
        this.cities = new ArrayList<>();
    }

    @Override
    public List<String> loadCities() {
        return new ArrayList<>(cities); // Return a copy to avoid external modification
    }

    @Override
    public void saveCities(List<String> cities) {
        this.cities.clear();
        this.cities.addAll(cities);
    }

    @Override
    public boolean addCity(String city) {
        if (!cities.contains(city)) {
            cities.add(city);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCity(String city) {
        return cities.remove(city);
    }
}
