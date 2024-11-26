package entity;

import java.util.ArrayList;
import java.util.List;

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
