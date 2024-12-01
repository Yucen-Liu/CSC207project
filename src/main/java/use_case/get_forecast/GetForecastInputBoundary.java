package use_case.get_forecast;

/**
 * Input Boundary for actions which are related to checking the weather history of the selected city in a user's account.
 */
public interface GetForecastInputBoundary {
    /**
     * Executes the getForecast use case.
     * @param getForecastInputData the input data
     */
    void execute(GetForecastInputData getForecastInputData);

    /**
     * Executes the switch to GetDetails view use case.
     */
    void switchToGetDetailsView();
}
