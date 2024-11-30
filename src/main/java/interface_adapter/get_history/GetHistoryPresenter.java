package interface_adapter.get_history;

import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.check_city.CheckCityState;
import interface_adapter.search_city.GetDetailsViewModel;
import use_case.get_history.GetHistoryOutputBoundary;
import use_case.get_history.GetHistoryOutputData;

/**
 * The Presenter for the GetHistory Use Case.
 */
public class GetHistoryPresenter implements GetHistoryOutputBoundary {
    private final GetHistoryViewModel getHistoryViewModel;
    private final ViewManagerModel viewManagerModel;
    private final GetDetailsViewModel getDetailsViewModel;

    public GetHistoryPresenter(GetHistoryViewModel getHistoryViewModel,
                               ViewManagerModel viewManagerModel,
                               GetDetailsViewModel searchCityViewModel) {
        this.getHistoryViewModel = getHistoryViewModel;
        this.viewManagerModel = viewManagerModel;
        this.getDetailsViewModel = searchCityViewModel;
    }

    @Override
    public void switchToGetDetailsView() {
        viewManagerModel.setState(getDetailsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    //There isn't anything to change based on the output data.
    public void prepareSuccessView(GetHistoryOutputData response) {
        final GetHistoryState getHistoryState = getHistoryViewModel.getState();
        getHistoryState.setTemperatureThreeHoursAgo(response.getTemperatureThreeHoursAgo());
        getHistoryState.setConditionThreeHoursAgo(response.getConditionThreeHoursAgo());
        getHistoryState.setHumidityThreeHoursAgo(response.getHumidityThreeHoursAgo());

        getHistoryState.setTemperatureSixHoursAgo(response.getTemperatureSixHoursAgo());
        getHistoryState.setConditionSixHoursAgo(response.getConditionSixHoursAgo());
        getHistoryState.setHumiditySixHoursAgo(response.getHumiditySixHoursAgo());

        getHistoryState.setTemperatureNineHoursAgo(response.getTemperatureNineHoursAgo());
        getHistoryState.setConditionNineHoursAgo(response.getConditionNineHoursAgo());
        getHistoryState.setHumidityNineHoursAgo(response.getHumidityNineHoursAgo());
        this.getHistoryViewModel.firePropertyChanged();
    }

    @Override
    // This use case currently can't fail
    public void prepareFailView(String errorMessage) {}
}
