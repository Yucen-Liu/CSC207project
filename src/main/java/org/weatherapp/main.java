package org.weatherapp;

import org.weatherapp.use_cases.WeatherService;
import org.weatherapp.view.WeatherGUI;

public class main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        WeatherGUI weatherGUI = new WeatherGUI(weatherService);

        // Start the GUI for the weather app
        weatherGUI.createAndShowGUI();
        // TODO: Add pictures and resources
    }
}
