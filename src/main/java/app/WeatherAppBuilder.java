package app;

import javax.swing.*;
import java.awt.*;

import data_access.CurWeatherInfoObject;
import data_access.ForecastWeatherInfoObject;
import entity.CommonCityFactory;
import entity.ForecastCityFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_forecast.GetForecastController;
import interface_adapter.get_forecast.GetForecastPresenter;
import interface_adapter.get_forecast.GetForecastViewModel;

import interface_adapter.get_details.GetDetailsViewModel;

import interface_adapter.search_city.SearchCityController;
import interface_adapter.search_city.SearchCityPresenter;
import interface_adapter.search_city.SearchCityViewModel;
import use_case.get_forecast.GetForecastInteractor;
import data_access.FavoriteCityStorageImpl;
import entity.*;

import interface_adapter.manage_cities.ManageCitiesController;

import use_case.manage_cities.FavoriteCitiesInteractor;
import use_case.search_city.SearchCityInputBoundary;
import use_case.search_city.SearchCityInteractor;
import use_case.search_city.SearchCityOutputBoundary;
import view.*;

public class WeatherAppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();

    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);
    private final CommonCityFactory commonCityFactory = new CommonCityFactory();
    private final CurWeatherInfoObject curWeatherInfoObject = new CurWeatherInfoObject(commonCityFactory);

    private SearchCityViewModel searchCityViewModel;
    private SearchCityView searchCityView;

    private GetForecastViewModel getForecastViewModel;
    private GetDetailsViewModel getDetailsViewModel;

    public WeatherAppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    public WeatherAppBuilder addSearchCityView() {
        searchCityViewModel = new SearchCityViewModel();
        searchCityView = new SearchCityView(searchCityViewModel);
        cardPanel.add(searchCityView, "weather app");
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

//     private final CheckCityDataAccessInterface curWeatherInfo = new CurWeatherInfoObject(new CommonCityFactory());
//     private final GetForecastDataAccessInterface forecastWeatherInfo = new ForecastWeatherInfoObject(
//             new ForecastCityFactory());

//     private CheckCityViewModel checkCityViewModel;
//     private GetForecastViewModel getForecastViewModel;
//     private GetDetailsViewModel getDetailsViewModel;

//     private ManageCityView manageCityView;
//     private SearchCityView searchCityView;
//     private CheckCityView checkCityView;
//     private GetForecastView getForecastView;

//     public WeatherAppBuilder() {cardPanel.setLayout(cardLayout);}

//    /**
//     * Adds the CheckCity View to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addCheckCityView() {
//        checkCityViewModel = new CheckCityViewModel();
//        checkCityView = new CheckCityView(checkCityViewModel);
//        cardPanel.add(checkCityView, checkCityView.getViewName());
//        return this;
//    }

//     /**
//      * Adds the GetForecast View to the application.
//      * @return this builder
//      */
//     public WeatherAppBuilder addGetForecastView() {
//         getForecastViewModel = new GetForecastViewModel();
//         getForecastView = new GetForecastView(getForecastViewModel);
//         cardPanel.add(getForecastView, getForecastView.getViewName());
//         return this;
//     }

//    /**
//     * Adds the CheckCity Use Case to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addCheckCityUseCase() {
//        final CheckCityOutputBoundary checkCityOutputBoundary = new CheckCityPresenter(checkCityViewModel,
//                viewManagerModel, loginViewModel, signupViewModel);
//        final CheckCityInputBoundary userCheckCityInteractor = new CheckCityInteractor(
//                curWeatherInfo, checkCityOutputBoundary);
//
//        final CheckCityController controller = new CheckCityController(userCheckCityInteractor);
//        checkCityView.setCheckCityController(controller);
//        return this;
//    }



    public WeatherAppBuilder addManageCityView() {
        FavoriteCitiesInteractor interactor = new FavoriteCitiesInteractor(new FavoriteCityStorageImpl());
        ManageCitiesController controller = new ManageCitiesController(interactor);
        ManageCityView view = new ManageCityView(controller);
        cardPanel.add(view, "manage cities");
        return this;
    }

    public WeatherAppBuilder addSearchCityUseCase(){
        final SearchCityOutputBoundary searchCityOutputBoundary =
                new SearchCityPresenter(searchCityViewModel, viewManagerModel);
        final SearchCityInputBoundary searchCityInteractor = new SearchCityInteractor(curWeatherInfoObject,
                searchCityOutputBoundary);

        final SearchCityController controller = new SearchCityController(searchCityInteractor, searchCityViewModel);
        searchCityView.setSearchCityController(controller);
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
