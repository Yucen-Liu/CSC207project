package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


import data_access.CurWeatherInfoObject;
import data_access.DBUserDataAccessObject;
import entity.CommonCityFactory;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.get_history.GetHistoryViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.check_city.CheckCityController;
import interface_adapter.check_city.CheckCityPresenter;
import interface_adapter.check_city.CheckCityViewModel;
import use_case.check_city.CheckCityDataAccessInterface;
import use_case.check_city.CheckCityInteractor;
import use_case.check_city.CheckCityInputBoundary;
import use_case.check_city.CheckCityOutputBoundary;
import view.*;

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
    private final CheckCityDataAccessInterface weatherService = new CurWeatherInfoObject(new CommonCityFactory());

    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private CheckCityViewModel checkCityViewModel;
    private GetHistoryViewModel getHistoryViewModel;

    private LoggedInView loggedInView;
    private LoginView loginView;
    private ManageCityView manageCityView;
    private SearchCityView searchCityView;
    private CheckCityView checkCityView;
    private GetHistoryView getHistoryView;

    public WeatherAppBuilder() {cardPanel.setLayout(cardLayout);}

//    /**
//     * Adds the Signup View to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addSignupView() {
//        signupViewModel = new SignupViewModel();
//        signupView = new SignupView(signupViewModel);
//        cardPanel.add(signupView, signupView.getViewName());
//        return this;
//    }

//    /**
//     * Adds the Login View to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addLoginView() {
//        loginViewModel = new LoginViewModel();
//        loginView = new LoginView(loginViewModel);
//        cardPanel.add(loginView, loginView.getViewName());
//        return this;
//    }
//
//    /**
//     * Adds the LoggedIn View to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addLoggedInView() {
//        loggedInViewModel = new LoggedInViewModel();
//        loggedInView = new LoggedInView(loggedInViewModel);
//        cardPanel.add(loggedInView, loggedInView.getViewName());
//        return this;
//    }
    /**
     * Adds the CheckCity View to the application.
     * @return this builder
     */
    public WeatherAppBuilder addCheckCityView() {
        checkCityViewModel = new CheckCityViewModel();
        checkCityView = new CheckCityView(checkCityViewModel);
        cardPanel.add(checkCityView, checkCityView.getViewName());
        return this;
    }

//    /**
//     * Adds the GetHistory View to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addGetHistoryView() {
//        getHistoryViewModel = new GetHistoryViewModel();
//        getHisView = new CheckCityView(checkCityViewModel);
//        cardPanel.add(checkCityView, checkCityView.getViewName());
//        return this;
//    }

//    /**
//     * Adds the Signup Use Case to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addSignupUseCase() {
//        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
//                signupViewModel, loginViewModel);
//        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
//                userDataAccessObject, signupOutputBoundary, userFactory);
//
//        final SignupController controller = new SignupController(userSignupInteractor);
//        signupView.setSignupController(controller);
//        return this;
//    }
//
//    /**
//     * Adds the Login Use Case to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addLoginUseCase() {
//        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
//                loggedInViewModel, loginViewModel);
//        final LoginInputBoundary loginInteractor = new LoginInteractor(
//                userDataAccessObject, loginOutputBoundary);
//
//        final LoginController loginController = new LoginController(loginInteractor);
//        loginView.setLoginController(loginController);
//        return this;
//    }
//
//    /**
//     * Adds the Change Password Use Case to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addChangePasswordUseCase() {
//        final ChangePasswordOutputBoundary changePasswordOutputBoundary =
//                new ChangePasswordPresenter(loggedInViewModel);
//
//        final ChangePasswordInputBoundary changePasswordInteractor =
//                new ChangePasswordInteractor(userDataAccessObject, changePasswordOutputBoundary, userFactory);
//
//        final ChangePasswordController changePasswordController =
//                new ChangePasswordController(changePasswordInteractor);
//        loggedInView.setChangePasswordController(changePasswordController);
//        return this;
//    }
//
//    /**
//     * Adds the Logout Use Case to the application.
//     * @return this builder
//     */
//    public WeatherAppBuilder addLogoutUseCase() {
//        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
//                loggedInViewModel, loginViewModel);
//
//        final LogoutInputBoundary logoutInteractor =
//                new LogoutInteractor(userDataAccessObject, logoutOutputBoundary);
//
//        final LogoutController logoutController = new LogoutController(logoutInteractor);
//        loggedInView.setLogoutController(logoutController);
//        return this;
//    }

    /**
     * Adds the CheckCity Use Case to the application.
     * @return this builder
     */
    public WeatherAppBuilder addCheckCityUseCase() {
        final CheckCityOutputBoundary checkCityOutputBoundary = new CheckCityPresenter(checkCityViewModel,
                viewManagerModel, loginViewModel, signupViewModel);
        final CheckCityInputBoundary userCheckCityInteractor = new CheckCityInteractor(
                weatherService, checkCityOutputBoundary);

        final CheckCityController controller = new CheckCityController(userCheckCityInteractor);
        checkCityView.setCheckCityController(controller);
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

        viewManagerModel.setState(checkCityView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;

    }
    }
