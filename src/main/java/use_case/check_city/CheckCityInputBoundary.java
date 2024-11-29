package use_case.check_city;

/**
 * Input Boundary for actions which are related to the home page.
 */
public interface CheckCityInputBoundary {

    /**
     * Executes the home use case.
     * @param checkcityInputData the input data
     */
    void execute(CheckCityInputData checkcityInputData);

    /**
     * Executes the switch to login view use case.
     */
    void switchToLoginView();

    /**
     * Executes the switch to signup view use case.
     */
    void switchToSignupView();
}
