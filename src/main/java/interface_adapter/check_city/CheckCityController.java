package interface_adapter.check_city;

import use_case.check_city.CheckCityInputBoundary;
import use_case.check_city.CheckCityInputData;

/**
 * The controller for the CheckCity Use Case.
 */
public class CheckCityController {

    private final CheckCityInputBoundary checkcityUseCaseInteractor;

    public CheckCityController(CheckCityInputBoundary checkcityUseCaseInteractor) {
        this.checkcityUseCaseInteractor= checkcityUseCaseInteractor;
    }

    /**
     * Executes the "switch to LoginView" Use Case.
     */
    public void switchToLoginView() {
        checkcityUseCaseInteractor.switchToLoginView();
    }

    /**
     * Executes the "switch to SignupView" Use Case.
     */
    public void switchToSignupView() {
        checkcityUseCaseInteractor.switchToSignupView();
    }

    /**
     * Executes the CheckCity Use Case.
     * @param cityname the name of the city the user wanted to verify for availability of weather
     * information in the application.
     */
    public void execute(String cityname) {
        final CheckCityInputData checkCityInputData = new CheckCityInputData(cityname);
        checkcityUseCaseInteractor.execute(checkCityInputData);
    }
}
