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
    public void execute(GetForecastInputData inputData) {
        try {
            ForecastCity forecastCity = weatherDataAccess.getWeatherForecast(inputData.getCityName(), 4);
            GetForecastOutputData outputData = new GetForecastOutputData(
                    forecastCity.getForecast(),
                    inputData.getCityName(),
                    inputData.getSavedCityNames(),
                    false
            );
            outputBoundary.prepareSuccessView(outputData);
        } catch (Exception e) {
            outputBoundary.prepareFailView("Failed to retrieve forecast: " + e.getMessage());
        }
    }

    @Override
    public void switchToGetDetailsView() {
        outputBoundary.switchToGetDetailsView();
    }
}
