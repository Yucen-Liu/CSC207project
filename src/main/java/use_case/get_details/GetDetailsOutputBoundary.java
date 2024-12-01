package use_case.get_details;

/**
 * The output boundary for the GetDetails Use Case.
 */
public interface GetDetailsOutputBoundary {

    /**
     * Switches to the SearchCity View.
     */
    void switchToSearchCityView();

    /**
     * Executes the switch to GetNearbyCities view use case.
     */
    void switchToGetGetNearbyCitiesView();

    /**
     * Executes the switch to GetForecast view use case.
     */
    void switchToGetForecastView();

    /**
     * Prepares the success view for the GetHistory Use Case.
     * @param getDetailsOutputData the output data
     */
    void prepareSuccessView(GetDetailsOutputData getDetailsOutputData);

    /**
     * Prepares the failure view for the GetHistory Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
