package app;

import interface_adapter.WeatherGUI;
import interface_adapter.manage_cities.ManageCitiesController;
import use_case.cities.ManageCitiesInteractor;
import use_case.weather.FetchWeatherData;
import data_access.CityStorageImpl;
import data_access.WeatherAPIImpl;

public class WeatherAppBuilder {

    public void buildAndLaunch() {
        // Initialize dependencies
        CityStorageImpl cityStorageImpl = new CityStorageImpl();
        WeatherAPIImpl weatherAPI = new WeatherAPIImpl();

        // Create use case interactors
        ManageCitiesInteractor manageCitiesInteractor = new ManageCitiesInteractor(cityStorageImpl);
        FetchWeatherData fetchWeatherData = new FetchWeatherData(weatherAPI);

        // Create controllers
        ManageCitiesController manageCitiesController = new ManageCitiesController(manageCitiesInteractor);

        // Initialize and launch the GUI
        WeatherGUI weatherGUI = new WeatherGUI(fetchWeatherData, manageCitiesInteractor);
        weatherGUI.createAndShowGUI();
    }
}
