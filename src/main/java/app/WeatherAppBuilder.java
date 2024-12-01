package app;

import javax.swing.*;
import java.awt.*;

import view.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.check_city.CheckCityController;
import interface_adapter.check_city.CheckCityPresenter;
import interface_adapter.check_city.CheckCityViewModel;
import interface_adapter.get_forecast.GetForecastController;
import interface_adapter.get_forecast.GetForecastViewModel;
import interface_adapter.manage_cities.ManageCitiesController;
import use_case.check_city.CheckCityInteractor;
import use_case.get_forecast.GetForecastInteractor;
import use_case.manage_cities.FavoriteCitiesInteractor;
import data_access.CurWeatherInfoObject;
import data_access.FavoriteCityStorageImpl;
import data_access.ForecastWeatherInfoObject;
import entity.CommonCityFactory;
import entity.ForecastCityFactory;

public class WeatherAppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    public WeatherAppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    public WeatherAppBuilder addCheckCityView() {
        // Create dependencies for the interactor
        CurWeatherInfoObject weatherInfo = new CurWeatherInfoObject(new CommonCityFactory());
        CheckCityViewModel viewModel = new CheckCityViewModel();

        // Create the presenter (implements CheckCityOutputBoundary)
        CheckCityPresenter presenter = new CheckCityPresenter(viewModel);

        // Create the interactor with the weatherInfo and presenter
        CheckCityInteractor interactor = new CheckCityInteractor(weatherInfo, presenter);

        // Create the controller
        CheckCityController controller = new CheckCityController(interactor);

        // Create the view and connect it to the controller
        CheckCityView view = new CheckCityView(viewModel);
        view.setCheckCityController(controller);

        // Add the view to the card panel
        cardPanel.add(view, view.getViewName());
        return this;
    }



    public WeatherAppBuilder addGetForecastView() {
        ForecastWeatherInfoObject forecastInfo = new ForecastWeatherInfoObject(new ForecastCityFactory());
        GetForecastInteractor interactor = new GetForecastInteractor(forecastInfo, null); // Provide OutputBoundary
        GetForecastController controller = new GetForecastController(interactor);
        GetForecastViewModel viewModel = new GetForecastViewModel();

        GetForecastView view = new GetForecastView(viewModel);
        view.setGetForecastController(controller);
        cardPanel.add(view, view.getViewName());
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

        viewManagerModel.setState("check city");
        return application;
    }
}
