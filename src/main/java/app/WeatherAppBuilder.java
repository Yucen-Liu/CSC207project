package app;

import javax.swing.*;
import java.awt.*;

import data_access.FavoriteCityStorageImpl;
import entity.*;
import interface_adapter.get_details.GetDetailsViewModel;
import interface_adapter.manage_cities.ManageCitiesController;
import use_case.manage_cities.FavoriteCitiesInteractor;
import view.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_forecast.GetForecastController;
import interface_adapter.get_forecast.GetForecastPresenter;
import interface_adapter.get_forecast.GetForecastViewModel;
import use_case.get_forecast.GetForecastInteractor;
import data_access.ForecastWeatherInfoObject;

public class WeatherAppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    public WeatherAppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    public WeatherAppBuilder addWeatherAppView() {
        // Create dependencies for WeatherAppView
        CityStorage cityStorage = new CommonCityStorage(); // Replace with the actual CityStorage implementation
        CityFactory cityFactory = new CommonCityFactory(); // Replace with the actual CityFactory implementation

        // Create GetForecastController dependencies
        ForecastWeatherInfoObject forecastInfo = new ForecastWeatherInfoObject(new ForecastCityFactory());
        GetForecastViewModel forecastViewModel = new GetForecastViewModel();
        GetDetailsViewModel detailsViewModel = new GetDetailsViewModel();
        GetForecastPresenter presenter = new GetForecastPresenter(forecastViewModel, viewManagerModel, detailsViewModel);
        GetForecastInteractor interactor = new GetForecastInteractor(forecastInfo, presenter);

        // Pass both interactor and viewModel to the controller
        GetForecastController forecastController = new GetForecastController(interactor, forecastViewModel);

        // Instantiate WeatherAppView with required dependencies
        WeatherAppView weatherAppView = new WeatherAppView(cityStorage, cityFactory, forecastController);
        cardPanel.add(weatherAppView, "weather app");
        return this;
    }


    public WeatherAppBuilder addGetForecastView() {
        // Create dependencies for GetForecastView
        ForecastWeatherInfoObject forecastInfo = new ForecastWeatherInfoObject(new ForecastCityFactory());
        GetForecastViewModel forecastViewModel = new GetForecastViewModel();
        GetDetailsViewModel detailsViewModel = new GetDetailsViewModel();
        GetForecastPresenter presenter = new GetForecastPresenter(forecastViewModel, viewManagerModel, detailsViewModel);
        GetForecastInteractor interactor = new GetForecastInteractor(forecastInfo, presenter);

        // Pass both interactor (as InputBoundary) and ViewModel to the controller
        GetForecastController controller = new GetForecastController(interactor, forecastViewModel);

        // Instantiate the view
        GetForecastView view = new GetForecastView(forecastViewModel);
        view.setGetForecastController(controller);
        cardPanel.add(view, "get forecast");
        return this;
    }


    public WeatherAppBuilder addManageCityView() {
        FavoriteCitiesInteractor interactor = new FavoriteCitiesInteractor(new FavoriteCityStorageImpl());
        ManageCitiesController controller = new ManageCitiesController(interactor);
        ManageCityView view = new ManageCityView(controller);
        cardPanel.add(view, "manage cities");
        return this;
    }

    public JFrame build() {
        JFrame application = new JFrame("Weather App");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLayout(new BorderLayout());
        application.add(cardPanel, BorderLayout.CENTER);
        application.setSize(800, 600);

        // Use ViewManager to set default view
        viewManager.switchTo("weather app");

        return application;
    }
}
