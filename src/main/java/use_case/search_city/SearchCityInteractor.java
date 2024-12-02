package use_case.search_city;

import entity.City;
import entity.CommonCity;

/**
 * The SearchCity Interactor.
 */
public class SearchCityInteractor implements SearchCityInputBoundary {

    private final SearchCityDataAccessInterface searchCityDataAccessObject;
    private final SearchCityOutputBoundary userPresenter;

    public SearchCityInteractor(SearchCityDataAccessInterface searchCityDataAccessInterface,
                                SearchCityOutputBoundary searchCityOutputBoundary) {
        this.searchCityDataAccessObject= searchCityDataAccessInterface;
        this.userPresenter = searchCityOutputBoundary;
    }

    @Override
    public void execute(SearchCityInputData searchCityInputData) {
        City city = searchCityDataAccessObject.getCurWeather(searchCityInputData.getCityname());
        final SearchCityOutputData searchCityOutputData = new SearchCityOutputData(city.getLocation(),
                city.getTemperature(), city.getCondition(), city.getHumidity(), searchCityInputData.getSavedCityNames());
        userPresenter.searchCityInformationView(searchCityOutputData);
    }

    public void switchToGetForecastView() { userPresenter.switchToGetForecastView(); }
    public void switchToGetNearbyCitiesView() { userPresenter.switchToGetNearbyCitiesView(); }
}

