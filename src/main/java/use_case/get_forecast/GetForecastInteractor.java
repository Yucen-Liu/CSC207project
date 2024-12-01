package use_case.get_forecast;

import entity.ForecastCity;

/**
 * The GetForecast Interactor.
 */
public class GetForecastInteractor implements GetForecastInputBoundary {
    private final GetForecastDataAccessInterface weatherDataAccess;
    private final GetForecastOutputBoundary outputBoundary;

    public GetForecastInteractor(GetForecastDataAccessInterface weatherDataAccess,
                                 GetForecastOutputBoundary outputBoundary) {
        this.weatherDataAccess = weatherDataAccess;
        this.outputBoundary = outputBoundary;
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
        outputBoundary.switchToGetDetailsView();
    }
}
