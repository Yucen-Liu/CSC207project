package interface_adapter.get_forecast;

import use_case.get_forecast.GetForecastInputBoundary;
import use_case.get_forecast.GetForecastInputData;

import java.util.List;

/**
 * The controller for the GetHistory Use Case.
 */
public class GetForecastController {

    private final GetForecastInputBoundary userGetHistoryUseCaseInteractor;

    public GetForecastController(GetForecastInputBoundary userGetHistoryUseCaseInteractor) {
        this.userGetHistoryUseCaseInteractor = userGetHistoryUseCaseInteractor;
    }

    /**
     * Executes the GetHistory Use Case.
     * @param cityName the username to sign up
     */
    public void execute(String cityName, List<String> savedCityNames) {
        final GetForecastInputData getForecastInputData = new GetForecastInputData(cityName, savedCityNames);
        userGetHistoryUseCaseInteractor.execute(getForecastInputData);
    }

    /**
     * Executes the "switch to SearchCity View" Use Case.
     */
    public void switchGetDetailsView() {
        userGetHistoryUseCaseInteractor.switchToGetDetailsView();
    }
}
