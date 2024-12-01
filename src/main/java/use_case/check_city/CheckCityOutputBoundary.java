package use_case.check_city;

public interface CheckCityOutputBoundary {
    /**
     * Presents a successful validation result.
     *
     * @param cityName the name of the successfully validated city
     */
    void presentSuccess(String cityName);

    /**
     * Presents a failure result with an error message.
     *
     * @param errorMessage the error message to present
     */
    void presentFailure(String errorMessage);
}
