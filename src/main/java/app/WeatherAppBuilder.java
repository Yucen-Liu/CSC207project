package app;

import javax.swing.*;
import java.awt.*;

import data_access.CurWeatherInfoObject;
import data_access.ForecastWeatherInfoObject;
import data_access.*;
import entity.CommonCityFactory;
import entity.ForecastCityFactory;
import interface_adapter.ViewManagerModel;

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
import interface_adapter.manage_sort.SortCitiesViewModel;
import interface_adapter.nearby_cities.NearbyCitiesController;
import interface_adapter.nearby_cities.NearbyCitiesPresenter;
import interface_adapter.nearby_cities.NearbyCitiesViewModel;
import interface_adapter.search_city.SearchCityPresenter;
import interface_adapter.search_city.SearchCityViewModel;
import use_case.get_forecast.GetForecastInputBoundary;
import use_case.get_forecast.GetForecastInteractor;
import use_case.get_forecast.GetForecastOutputBoundary;
import entity.*;

import use_case.nearby_cities.NearbyCitiesInputBoundary;
import use_case.nearby_cities.NearbyCitiesInteractor;
import use_case.nearby_cities.NearbyCitiesOutputBoundary;
import use_case.search_city.SearchCityOutputBoundary;
import view.*;
import interface_adapter.get_forecast.GetForecastController;
import interface_adapter.get_forecast.GetForecastPresenter;
import interface_adapter.get_forecast.GetForecastViewModel;
import data_access.ForecastWeatherInfoObject;

public class WeatherAppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();

    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);
    private final CommonCityFactory commonCityFactory = new CommonCityFactory();
    private final CurWeatherInfoObject curWeatherInfoObject = new CurWeatherInfoObject(commonCityFactory);

    private final ForecastWeatherInfoObject forecastWeatherInfoObject = new ForecastWeatherInfoObject(new ForecastCityFactory());
    private final DetailedWeatherInfoObject detailedWeatherInfoObject = new DetailedWeatherInfoObject(new DetailedCityFactory());
    private final NearbyCityWeatherAccessObject nearbyCityWeatherAccessObject = new NearbyCityWeatherAccessObject(new NearbyCityFactory());



    private GetForecastViewModel getForecastViewModel;
    private GetForecastView getForecastView;

    private NearbyCitiesViewModel nearbyCitiesViewModel;
    private GetNearbyCitiesView getNearbyCitiesView;

    private SortCitiesViewModel sortCitiesViewModel;
    private SortCitiesView sortCitiesView;

    private SearchCityViewModel searchCityViewModel;
    private SearchCityView searchCityView;

    private GetDetailsViewModel getDetailsViewModel;
    private GetDetailsView getDetailsView;

    public WeatherAppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    public WeatherAppBuilder addSearchCityView() {
        searchCityViewModel = new SearchCityViewModel();
        searchCityView = new SearchCityView(searchCityViewModel);
        cardPanel.add(searchCityView, "weather app");
        return this;
    }

//
//        SearchCityViewModel searchCityViewModel = new SearchCityViewModel();
//
//
//        // Instantiate WeatherAppView with required dependencies
//        SearchCityView searchCityView = new SearchCityView(searchCityViewModel);
//        cardPanel.add(searchCityView, "weather app");
//        return this;
//    }
//    public WeatherAppBuilder addWeatherAppView() {
//        // Create dependencies for WeatherAppView
//        CityStorage cityStorage = new CommonCityStorage(); // Replace with actual implementation
//        CityFactory cityFactory = new CommonCityFactory(); // Replace with actual implementation
//
//        // Create GetForecastController dependencies
//        ForecastWeatherInfoObject forecastInfo = new ForecastWeatherInfoObject(new ForecastCityFactory());
//        GetForecastViewModel forecastViewModel = new GetForecastViewModel();
//        GetDetailsViewModel detailsViewModel = new GetDetailsViewModel();
//        GetForecastPresenter forecastPresenter = new GetForecastPresenter(forecastViewModel, viewManagerModel, detailsViewModel);
//        GetForecastInteractor forecastInteractor = new GetForecastInteractor(forecastInfo, forecastPresenter);
//        GetForecastController forecastController = new GetForecastController(forecastInteractor, forecastViewModel);
//
//
//        // Instantiate WeatherAppView with required dependencies
//        WeatherAppView weatherAppView = new WeatherAppView(cityStorage, cityFactory, forecastController);
//        cardPanel.add(weatherAppView, "weather app");
//        return this;
//    }
//
//
//
//    public WeatherAppBuilder addGetForecastView() {
//        // Create dependencies for GetForecastView
//        ForecastWeatherInfoObject forecastInfo = new ForecastWeatherInfoObject(new ForecastCityFactory());
//        GetForecastViewModel forecastViewModel = new GetForecastViewModel();
//        GetDetailsViewModel detailsViewModel = new GetDetailsViewModel();
//        GetForecastPresenter presenter = new GetForecastPresenter(forecastViewModel, viewManagerModel, detailsViewModel);
//        GetForecastInteractor interactor = new GetForecastInteractor(forecastInfo, presenter);
//
//        // Pass both interactor (as InputBoundary) and ViewModel to the controller
//        GetForecastController controller = new GetForecastController(interactor, forecastViewModel);
//
//        // Instantiate the view
//        GetForecastView view = new GetForecastView(forecastViewModel);
//        view.setGetForecastController(controller);
//        cardPanel.add(view, "get forecast");
//        return this;
//    }

     /**
      * Adds the GetForecast View to the application.
      * @return this builder
      */
     public WeatherAppBuilder addGetForecastView() {
         getForecastViewModel = new GetForecastViewModel();
         getForecastView = new GetForecastView(getForecastViewModel);
         cardPanel.add(getForecastView, getForecastView.getViewName());
         return this;
     }

//    /**
//     * Adds the GetDetails View to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addGetDetailsView() {
//        getDetailsViewModel = new GetDetailsViewModel();
//        getDetailsView = new GetDetailsView(getDetailsViewModel);
//        cardPanel.add(getDetailsView, getDetailsView.getViewName());
//        return this;
//    }

//    /**
//     * Adds the ManageSort View to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addManageSortView() {
//        sortCitiesViewModel = new SortCitiesViewModel();
//        sortCitiesView = new SortCitiesView(sortCitiesViewModel);
//        cardPanel.add(sortCitiesView, sortCitiesView.getViewName());
//        return this;
//    }

    /**
     * Adds the NearbyCities View to the application.
     * @return this builder
     */
    public WeatherAppBuilder addNearbyCitiesView() {
        nearbyCitiesViewModel = new NearbyCitiesViewModel();
        getNearbyCitiesView = new GetNearbyCitiesView(nearbyCitiesViewModel);
        cardPanel.add(getNearbyCitiesView, getNearbyCitiesView.getViewName());
        return this;
    }

//    /**
//     * Adds the SearchCity View to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addSearchCityView() {
//        searchCityViewModel = new SearchCityViewModel();
//        searchCityView = new SearchCityView(searchCityViewModel);
//        cardPanel.add(searchCityView, searchCityView.getViewName());
//        return this;
//    }


    /**
     * Adds the GetForecast Use Case to the application.
     * @return this builder
     */
    public WeatherAppBuilder addGetForecastUseCase() {
        final GetForecastOutputBoundary getForecastOutputBoundary = new GetForecastPresenter(getForecastViewModel,
                viewManagerModel, getDetailsViewModel);
        final GetForecastInputBoundary userInteractor = new GetForecastInteractor(
                forecastWeatherInfoObject, getForecastOutputBoundary);

        final GetForecastController controller = new GetForecastController(userInteractor, getForecastViewModel);
        getForecastView.setGetForecastController(controller);
        return this;
    }

    /**
     * Adds the NearbyCities Use Case to the application.
     * @return this builder
     */
    public WeatherAppBuilder addNearbyCitiesUseCase() {
        final NearbyCitiesOutputBoundary outputBoundary = new NearbyCitiesPresenter(nearbyCitiesViewModel,
                viewManagerModel, getDetailsViewModel);
        final NearbyCitiesInputBoundary userInteractor = new NearbyCitiesInteractor(
                nearbyCityWeatherAccessObject,outputBoundary);

        final NearbyCitiesController controller = new NearbyCitiesController(userInteractor);
        getNearbyCitiesView.setNearbyCitiesController(controller);
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


//    /**
//     * Adds the SearchCity Use Case to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addSearchCityUseCase() {
//        final SearchCityOutputBoundary outputBoundary = new SearchCityPresenter();
//        final NearbyCitiesInputBoundary userInteractor = new NearbyCitiesInteractor(
//                nearbyCityWeatherAccessObject,outputBoundary);
//
//        final NearbyCitiesController controller = new NearbyCitiesController(userInteractor);
//        getNearbyCitiesView.setNearbyCitiesController(controller);
//        return this;
//    }

//
//    public WeatherAppBuilder addManageCityView() {
//        FavoriteCitiesInteractor interactor = new FavoriteCitiesInteractor(new FavoriteCityStorageImpl());
//        ManageCitiesController controller = new ManageCitiesController(interactor);
//        ManageCityView view = new ManageCityView(controller);
//        cardPanel.add(view, "manage cities");
//        return this;
//    }

//    public JFrame build() {
//        JFrame application = new JFrame("Weather App");
//        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        application.setLayout(new BorderLayout());
//        application.add(cardPanel, BorderLayout.CENTER);
//        application.setSize(800, 600);
//
//        // Use ViewManager to set default view
//        viewManager.switchTo("weather app");
//
//        return application;
//    }

    /**
     * Creates the JFrame for the application and initially sets the SignupView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Weather Information Application");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(getForecastViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }


}
