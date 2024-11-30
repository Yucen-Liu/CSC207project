package interface_adapter.get_forecast;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_city.GetDetailsViewModel;
import use_case.get_forecast.GetForecastOutputBoundary;
import use_case.get_forecast.GetForecastOutputData;

/**
 * The Presenter for the GetHistory Use Case.
 */
public class GetForecastPresenter implements GetForecastOutputBoundary {
    private final GetForecastViewModel getForecastViewModel;
    private final ViewManagerModel viewManagerModel;
    private final GetDetailsViewModel getDetailsViewModel;

    public GetForecastPresenter(GetForecastViewModel getForecastViewModel,
                                ViewManagerModel viewManagerModel,
                                GetDetailsViewModel searchCityViewModel) {
        this.getForecastViewModel = getForecastViewModel;
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
    public void prepareSuccessView(GetForecastOutputData response) {
        final GetForecastState getForecastState = getForecastViewModel.getState();
        getForecastState.setTemperatureThreeHoursLater(response.getTemperatureThreeHoursLater());
        getForecastState.setConditionThreeHoursLater(response.getConditionThreeHoursLater());
        getForecastState.setHumidityThreeHoursLater(response.getHumidityThreeHoursLater());

        getForecastState.setTemperatureSixHoursLater(response.getTemperatureSixHoursLater());
        getForecastState.setConditionSixHoursLater(response.getConditionSixHoursLater());
        getForecastState.setHumiditySixHoursLater(response.getHumiditySixHoursLater());

        getForecastState.setTemperatureNineHoursLater(response.getTemperatureNineHoursLater());
        getForecastState.setConditionNineHoursLater(response.getConditionNineHoursLater());
        getForecastState.setHumidityNineHoursLater(response.getHumidityNineHoursLater());
        this.getForecastViewModel.firePropertyChanged();
    }

    @Override
    // This use case currently can't fail
    public void prepareFailView(String errorMessage) {}
}
