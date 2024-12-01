package use_case.get_details;

import use_case.get_forecast.GetForecastInputData;

public interface GetDetailsInputBoundary {
    /**
     * Executes the getForecast use case.
     * @param getForecastInputData the input data
     */
    void execute(GetForecastInputData getForecastInputData);

    /**
     * Executes the switch to GetForecast view use case.
     */
    void switchToGetForecastView();

    /**
     * Executes the switch to GetNearbyCities view use case.
     */
    void switchToGetGetNearbyCitiesView();

    /**
     * Executes the switch to SearchCity view use case.
     */
    void switchToSearchCityView();


}
