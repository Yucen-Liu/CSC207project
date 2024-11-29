package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


import data_access.DBUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.ChangePasswordPresenter;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.manage_cities.ManageCitiesController;
import interface_adapter.manage_cities.ManageCitiesPresenter;
import interface_adapter.manage_cities.ManageCitiesViewModel;
import interface_adapter.search_city.SearchCityController;
import interface_adapter.search_city.SearchCityPresenter;
import interface_adapter.search_city.SearchCityViewModel;
import interface_adapter.check_city.CheckCityController;
import interface_adapter.check_city.CheckCityPresenter;
import interface_adapter.check_city.CheckCityViewModel;
import org.weatherapp.WeatherService;
import use_case.change_password.ChangePasswordInputBoundary;
import use_case.change_password.ChangePasswordInteractor;
import use_case.change_password.ChangePasswordOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.search_city.SearchCityInputBoundary;
import use_case.search_city.SearchCityInteractor;
import use_case.search_city.SearchCityOutputBoundary;
import use_case.manage_cities.ManageCitiesInputBoundary;
import use_case.manage_cities.ManageCitiesInteractor;
import use_case.manage_cities.ManageCitiesOutputBoundary;
import use_case.check_city.CheckCityInteractor;
import use_case.check_city.CheckCityInputBoundary;
import use_case.check_city.CheckCityOutputBoundary;
import view.LoggedInView;
import view.LoginView;
import view.SignupView;
import view.SearchCityView;
import view.ManageCityView;
import view.ViewManager;
import view.CheckCityView;

/**
 * The WeatherAppBuilder class responsible for putting together the CA.
 */

public class WeatherAppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final UserFactory userFactory = new CommonUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final DBUserDataAccessObject userDataAccessObject = new DBUserDataAccessObject();
    private final WeatherService weatherService = new WeatherService();

    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private ManageCityView manageCityView;
    private SearchCityView searchCityView;
    private CheckCityView checkCityView;

    public WeatherAppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    }
