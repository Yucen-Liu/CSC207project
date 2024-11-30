package interface_adapter.get_history;

import use_case.get_history.GetHistoryInputBoundary;
import use_case.get_history.GetHistoryInputData;

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
    public void execute(String cityName) {
        final GetHistoryInputData getHistoryInputData = new GetHistoryInputData(cityName);
        userGetHistoryUseCaseInteractor.execute(getHistoryInputData);
    }

    /**
     * Executes the "switch to SearchCity View" Use Case.
     */
    public void switchSearchCityView() {
        userGetHistoryUseCaseInteractor.switchToSearchCityView();
    }
}
