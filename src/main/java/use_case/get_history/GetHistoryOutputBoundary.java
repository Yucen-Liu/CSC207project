package use_case.get_history;

/**
 * The output boundary for the GetHistory Use Case.
 */
public interface GetHistoryOutputBoundary {
    /**
     * Switches to the SearchCity View.
     */
    void switchToSearchCityView();
    /**
     * Prepares the success view for the GetHistory Use Case.
     * @param getHistoryOutputData the output data
     */
    void prepareSuccessView(GetHistoryOutputData getHistoryOutputData);

    /**
     * Prepares the failure view for the GetHistory Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
