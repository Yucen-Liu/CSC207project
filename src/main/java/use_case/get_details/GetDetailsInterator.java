package use_case.get_details;

import use_case.get_forecast.GetForecastDataAccessInterface;
import use_case.get_forecast.GetForecastOutputBoundary;

public class GetDetailsInterator implements GetDetailsInputBoundary{

    private final GetDetailsDataAccessInterface weatherDataAccessObject;
    private final GetDetailsOutputBoundary userPresenter;

    GetDetailsInterator(GetDetailsDataAccessInterface weatherDataAccessObject,GetDetailsOutputBoundary userPresenter) {
        this.weatherDataAccessObject = weatherDataAccessObject;
        this.userPresenter = userPresenter;
    }

    @Override
    public void execute(GetDetailsInputData getForecastInputData) {

    }

    @Override
    public void switchToGetForecastView() {
        userPresenter.switchToGetForecastView();

    }

    @Override
    public void switchToGetNearbyCitiesView() {
        userPresenter.switchToGetNearbyCitiesView();
    }

    @Override
    public void switchToSearchCityView() {
        userPresenter.switchToSearchCityView();
    }
}
