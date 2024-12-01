package interface_adapter.get_forecast;

import use_case.get_forecast.GetForecastInputBoundary;

import java.util.List;

public class GetForecastController {

    private final GetForecastInputBoundary interactor;
    private final GetForecastViewModel viewModel;

    public GetForecastController(GetForecastInputBoundary interactor, GetForecastViewModel viewModel) {
        this.interactor = interactor;
        this.viewModel = viewModel;
    }

    /**
     * Executes the GetForecast use case.
     * @param cityName The city name for which the forecast is requested.
     * @param savedCityNames The list of saved city names.
     */
    public void execute(String cityName, List<String> savedCityNames) {
        interactor.execute(new use_case.get_forecast.GetForecastInputData(cityName, savedCityNames));
    }

    /**
     * Switches to the GetDetails view.
     */
    public void switchToGetDetailsView() {
        interactor.switchToGetDetailsView();
    }

    public GetForecastViewModel getViewModel() {
        return viewModel;
    }
}
