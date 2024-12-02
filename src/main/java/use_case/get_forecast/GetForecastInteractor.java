package use_case.get_forecast;

import entity.ForecastCity;

/**
 * The GetForecast Interactor.
 */
public class GetForecastInteractor implements GetForecastInputBoundary {
    private final GetForecastDataAccessInterface weatherDataAccessObject;
    private final GetForecastOutputBoundary userPresenter;

    public GetForecastInteractor(GetForecastDataAccessInterface weatherDataAccess,
                                 GetForecastOutputBoundary userPresenter) {
        this.weatherDataAccessObject = weatherDataAccess;
        this.userPresenter = userPresenter;
    }

    @Override
    public void execute(GetForecastInputData getForecastInputData) {
        if ( getForecastInputData.getCityName() == null || getForecastInputData.getCityName().isEmpty()) {
            userPresenter.prepareFailView("Unable to fetch the name of the selected city.");
            return;
        }
        try {

            ForecastCity forecastCity = weatherDataAccessObject.getWeatherForecast(getForecastInputData.getCityName(), 4);
            GetForecastOutputData getForecastoutputData = new GetForecastOutputData(forecastCity.getForecast(),
                    getForecastInputData.getCityName(), getForecastInputData.getSavedCityNames(),
                    false
            );
            userPresenter.prepareSuccessView(getForecastoutputData);
        } catch (Exception e) {
            userPresenter.prepareFailView(
                    "Unable to fetch the weather forecast information for the selected city: " + e.getMessage());
        }
    }

    @Override
    public void switchToGetDetailsView() {
        userPresenter.switchToGetDetailsView();
    }
}
