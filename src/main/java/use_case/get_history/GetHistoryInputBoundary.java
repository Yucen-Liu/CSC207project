package use_case.get_history;

import use_case.check_city.CheckCityInputData;

/**
 * Input Boundary for actions which are related to the home page.
 */
public interface GetHistoryInputBoundary {
    /**
     * Executes the home use case.
     * @param gethistoryInputData the input data
     */
    void execute(GetHistoryInputData gethistoryInputData);

    /**
     * Executes the switch to SearchCity view use case.
     */
    void switchToSearchCityView();

}
