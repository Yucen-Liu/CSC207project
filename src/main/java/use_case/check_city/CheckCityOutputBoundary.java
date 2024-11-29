package use_case.check_city;

/**
 * The output boundary for the CheckCity Use Case.
 */
public interface CheckCityOutputBoundary {
    /**
     * Switches to the Login View.
     */
    void switchToLoginView();

    /**
     * Switches to the Signup View.
     */
    void switchToSignupView();

    /**
     * Prepares the success lookup for city for the CheckCity Use Case.
     * @param successResult the explanation of the success.
     */
    void citynameExist(String successResult);

    /**
     * Prepares the success lookup for city for the CheckCity Use Case.
     * @param failedResult the explanation of the success.
     */
    void citynameNonExist(String failedResult);
}

