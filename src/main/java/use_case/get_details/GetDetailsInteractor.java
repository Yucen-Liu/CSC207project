package use_case.get_details;

import entity.DetailedCity;

/**
 * The GetDetails Interactor.
 */
public class GetDetailsInteractor implements GetDetailsInputBoundary{

    private final GetDetailsDataAccessInterface weatherDataAccessObject;
    private final GetDetailsOutputBoundary userPresenter;

    public GetDetailsInteractor(GetDetailsDataAccessInterface weatherDataAccessObject, GetDetailsOutputBoundary userPresenter) {
        this.weatherDataAccessObject = weatherDataAccessObject;
        this.userPresenter = userPresenter;
    }

    @Override
    public void execute(GetDetailsInputData getDetailsInputData) {
        if ( getDetailsInputData.getCityName() == null || getDetailsInputData.getCityName().isEmpty()) {
            userPresenter.prepareFailView("Unable to fetch the name of the selected city:");
            return;
        }
        try {
            DetailedCity detailedCity = weatherDataAccessObject.getDetailedWeather(getDetailsInputData.getCityName());
            GetDetailsOutputData getDetailsOutputData = new GetDetailsOutputData (getDetailsInputData.getCityName(),
                    getDetailsInputData.getSavedCityNames(), detailedCity.getTemperature(),
                    detailedCity.getCondition(),detailedCity.getHumidity(), detailedCity.getTempMin(),
                    detailedCity.getTempMax(), detailedCity.getPressure(),
                    detailedCity.getVisibility(), false);
            userPresenter.prepareSuccessView(getDetailsOutputData);
        } catch (Exception e) {
            userPresenter.prepareFailView(
                    "Unable to fetch the detailed information for the selected city:" + e.getMessage());
        }
    }

    @Override
    public void switchToGetForecastView() {userPresenter.switchToGetForecastView();}

    @Override
    public void switchToGetNearbyCitiesView() {
    userPresenter.switchToGetNearbyCitiesView();
}

    @Override
    public void switchToSearchCityView() {
    userPresenter.switchToSearchCityView();
}}
