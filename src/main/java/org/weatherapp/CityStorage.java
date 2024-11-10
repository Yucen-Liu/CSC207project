package org.weatherapp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// Class to manage the list of saved cities
public class CityStorage {
    private final DefaultListModel<String> cityListModel; // Model to store city names

    public CityStorage() {
        this.cityListModel = new DefaultListModel<>();
    }

    public DefaultListModel<String> getCityListModel() {
        return cityListModel;
    }

    // Adds a city to the list if it's not already present
    public void addCity(String city) {
        if (city != null && !city.isEmpty() && !cityListModel.contains(city)) {
            cityListModel.addElement(city);
        }
    }
}
