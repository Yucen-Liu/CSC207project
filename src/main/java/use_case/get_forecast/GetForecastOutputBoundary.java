package use_case.get_forecast;

/**
 * The output boundary for the GetHistory Use Case.
 */
public interface GetForecastOutputBoundary {
    /**
     * Switches to the SearchCity View.
     */
    void switchToGetDetailsView();
    /**
     * Prepares the success view for the GetHistory Use Case.
     * @param getForecastOutputData the output data
     */
    void prepareSuccessView(GetForecastOutputData getForecastOutputData);

    /**
     * Prepares the failure view for the GetHistory Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
