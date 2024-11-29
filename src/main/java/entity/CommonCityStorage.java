package entity;

import javax.swing.*;

/**
 * An implementation of the CityStorage interface.
 */
public class CommonCityStorage implements CityStorage {

    private final DefaultListModel<City> cities;

    public CommonCityStorage() {
        this.cities = new DefaultListModel<>();
    }

    public CommonCityStorage(DefaultListModel<City> cities) {
        this.cities = cities;
    }

    public DefaultListModel<City> getCities() {
        return cities;
    }

    @Override
    public void addCity(City city) {
        if (city != null && !city.getLocation().isEmpty() && !cities.contains(city)) {
            cities.addElement(city);
        }
    }

    @Override
    public void removeCity(City city){
        if (city != null && !cities.contains(city)) {
            cities.removeElement(city);
        }
        }
}
