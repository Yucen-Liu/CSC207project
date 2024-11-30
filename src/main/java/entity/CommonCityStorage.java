package entity;

import java.util.List;
import java.util.ArrayList;

/**
 * An implementation of the CityStorage interface.
 */
public class CommonCityStorage implements CityStorage {

    private final List<City> cities;

    public CommonCityStorage() {
        this.cities = new ArrayList<>();
    }

    public CommonCityStorage(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public void addCity(City city) {
        if (city != null && !city.getLocation().isEmpty() && !cities.contains(city)) {
            cities.add(city);
        }
    }

    @Override
    public void removeCity(City city){
        if (city != null && !cities.contains(city)) {
            cities.remove(city);
        }
        }
}
