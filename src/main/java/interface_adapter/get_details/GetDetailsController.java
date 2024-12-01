package interface_adapter.get_details;
;
import interface_adapter.get_forecast.GetForecastViewModel;
import use_case.get_details.GetDetailsInputBoundary;
import use_case.get_details.GetDetailsOutputData;

import java.util.List;

public class GetDetailsController {
    private final GetDetailsInputBoundary interactor;
    private final GetDetailsViewModel viewModel;

    public GetDetailsController(GetDetailsInputBoundary interactor, GetDetailsViewModel model) {
        this.interactor = interactor;
        this.viewModel = model;
    }

    /**
     * Executes the GetForecast use case.
     * @param cityName The city name for which the forecast is requested.
     * @param savedCityNames The list of saved city names.
     */
    public void execute(String cityName, List<String> savedCityNames) {
        interactor.execute(new use_case.get_details.GetDetailsInputData(cityName, savedCityNames));
    }

    /**
     * Switches to the SearchCity view.
     */
    public void switchToSearchCityView() {
        interactor.switchToSearchCityView();
    }

    /**
     * Switches to the GetForecast view.
     */
    public void switchToGetForecastView() {interactor.switchToGetForecastView();}

    /**
     * Switches to the GetNearbyCities view.
     */
    public void switchToGetNearbyCitiesView() {interactor.switchToGetNearbyCitiesView();}

    public GetDetailsViewModel
    getViewModel() {
        return viewModel;
    }
}
