package use_case.get_forecast;

import entity.ForecastCity;

/**
 * The GetHistory Interactor.
 */
public class GetForecastInteractor implements GetForecastInputBoundary {
    private final GetForecastDataAccessInterface weatherDataAccessObject;
    private final GetForecastOutputBoundary userPresenter;

    public GetForecastInteractor(GetForecastDataAccessInterface signupDataAccessInterface,
                                 GetForecastOutputBoundary signupOutputBoundary) {
        this.weatherDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
    }

    @Override
    public void execute(GetForecastInputData getForecastInputData) {
        if ( getForecastInputData.getCityName() == null || getForecastInputData.getCityName().isEmpty()) {
            userPresenter.prepareFailView("City name cannot be empty.");
            return;
        }

        try {
            ForecastCity forecastCity = weatherDataAccessObject.getWeatherForecast(getForecastInputData.getCityName(), 4);
            GetForecastOutputData outputData = new GetForecastOutputData(
                    forecastCity.getForecast(),
                    getForecastInputData.getCityName(),
                    getForecastInputData.getSavedCityNames(),
                    false
            );
            userPresenter.prepareSuccessView(outputData);
        } catch (Exception e) {
            userPresenter.prepareFailView("Failed to retrieve forecast: " + e.getMessage());
        }


         final ForecastCity forecastCity = weatherDataAccessObject.getWeatherForecast(getForecastInputData.getCityName(), 4);
         final GetForecastOutputData getForecastOutputData = new GetForecastOutputData((forecastCity.getForecast()),
                 getForecastInputData.getCityName(), getForecastInputData.getSavedCityNames(),false);
        userPresenter.prepareSuccessView(getForecastOutputData);
    }

    @Override
    public void switchToGetDetailsView() {
        userPresenter.switchToGetDetailsView();
    }
}
