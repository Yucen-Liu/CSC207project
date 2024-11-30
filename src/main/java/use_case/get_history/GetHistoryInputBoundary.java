package use_case.get_history;

/**
 * Input Boundary for actions which are related to checking the weather history of the selected city in a user's account.
 */
public interface GetHistoryInputBoundary {
    /**
     * Executes the signup use case.
     * @param getHistoryInputData the input data
     */
    void execute(GetHistoryInputData getHistoryInputData);

    /**
     * Executes the switch to SearchCity view use case.
     */
    void switchToSearchCityView();
}
