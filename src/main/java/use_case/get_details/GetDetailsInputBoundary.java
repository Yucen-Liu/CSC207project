package use_case.get_details;

public interface GetDetailsInputBoundary {
    /**
     * Executes the getForecast use case.
     * @param getForecastInputData the input data
     */
    void execute(GetDetailsInputData getForecastInputData);

    /**
     * Executes the switch to GetForecast view use case.
     */
    void switchToGetForecastView(String cityName);

    /**
     * Executes the switch to GetNearbyCities view use case.
     */
    void switchToGetNearbyCitiesView(String cityName);

    /**
     * Executes the switch to SearchCity view use case.
     */
    void switchToSearchCityView();


}
