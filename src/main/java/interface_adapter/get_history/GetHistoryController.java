package interface_adapter.get_history;

import use_case.get_history.GetHistoryInputBoundary;
import use_case.get_history.GetHistoryInputData;

import java.util.List;

/**
 * The controller for the GetHistory Use Case.
 */
public class GetHistoryController {

    private final GetHistoryInputBoundary userGetHistoryUseCaseInteractor;

    public GetHistoryController(GetHistoryInputBoundary userGetHistoryUseCaseInteractor) {
        this.userGetHistoryUseCaseInteractor = userGetHistoryUseCaseInteractor;
    }

    /**
     * Executes the GetHistory Use Case.
     * @param cityName the username to sign up
     */
    public void execute(String cityName, List<String> savedCityNames) {
        final GetHistoryInputData getHistoryInputData = new GetHistoryInputData(cityName, savedCityNames);
        userGetHistoryUseCaseInteractor.execute(getHistoryInputData);
    }

    /**
     * Executes the "switch to SearchCity View" Use Case.
     */
    public void switchGetDetailsView() {
        userGetHistoryUseCaseInteractor.switchToGetDetailsView();
    }
}
