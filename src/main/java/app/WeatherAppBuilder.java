package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


import data_access.CurWeatherInfoObject;
import data_access.ForecastWeatherInfoObject;
import entity.CommonCityFactory;
import entity.ForecastCityFactory;
import interface_adapter.ViewManagerModel;
;
import interface_adapter.get_forecast.GetForecastController;
import interface_adapter.get_forecast.GetForecastPresenter;
import interface_adapter.get_forecast.GetForecastViewModel;

import interface_adapter.get_details.GetDetailsViewModel;

import use_case.check_city.CheckCityDataAccessInterface;

import use_case.get_forecast.GetForecastDataAccessInterface;
import use_case.get_forecast.GetForecastInputBoundary;
import use_case.get_forecast.GetForecastInteractor;
import use_case.get_forecast.GetForecastOutputBoundary;
import view.*;

/**
 * The WeatherAppBuilder class responsible for putting together the CA.
 */

public class WeatherAppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final CheckCityDataAccessInterface curWeatherInfo = new CurWeatherInfoObject(new CommonCityFactory());
    private final GetForecastDataAccessInterface forecastWeatherInfo = new ForecastWeatherInfoObject(
            new ForecastCityFactory());

    private GetForecastViewModel getForecastViewModel;
    private GetDetailsViewModel getDetailsViewModel;

    private ManageCityView manageCityView;
    private SearchCityView searchCityView;
    private CheckCityView checkCityView;
    private GetForecastView getForecastView;

    public WeatherAppBuilder() {cardPanel.setLayout(cardLayout);}

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

    /**
     * Adds the GetForecast Use Case to the application.
     * @return this builder
     */
    public WeatherAppBuilder addGetForecastUseCase() {
        final GetForecastOutputBoundary getForecastOutputBoundary = new GetForecastPresenter(getForecastViewModel,
                viewManagerModel, getDetailsViewModel);
        final GetForecastInputBoundary userGetForecastInteractor = new GetForecastInteractor(
                forecastWeatherInfo, getForecastOutputBoundary);
        final GetForecastController controller = new GetForecastController(userGetForecastInteractor);
        getForecastView.setGetForecastController(controller);
        return this;
    }

     /**
     * Creates the JFrame for the application and initially sets the SignupView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Weather Information Application");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(getForecastView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;

    }
    }
