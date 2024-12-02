package use_case.search_city;

import entity.City;
import entity.CommonCity;

import java.util.List;

/**
 * The SearchCity Interactor.
 */
public class SearchCityInteractor implements SearchCityInputBoundary {

    private final SearchCityDataAccessInterface searchCityDataAccessObject;
    private final SearchCityOutputBoundary userPresenter;

    public SearchCityInteractor(SearchCityDataAccessInterface searchCityDataAccessInterface,
                                SearchCityOutputBoundary searchCityOutputBoundary) {
        this.searchCityDataAccessObject = searchCityDataAccessInterface;
        this.userPresenter = searchCityOutputBoundary;
    }

    @Override
    public void execute(SearchCityInputData searchCityInputData) {
        City city = searchCityDataAccessObject.getCurWeather(searchCityInputData.getCityname());
        final SearchCityOutputData searchCityOutputData = new SearchCityOutputData(city.getLocation(),
                city.getTemperature(), city.getCondition(), city.getHumidity(), searchCityInputData.getSavedCityNames());
        userPresenter.searchCityInformationView(searchCityOutputData);
    }

    @Override
    public void switchToGetDetailsView(String cityName) { userPresenter.switchToGetDetailsView(cityName); }

    @Override
    public void switchToSortCitiesView(List<String> savedCityNames) {
        userPresenter.switchToSortCitiesView(savedCityNames);
    }

    @Override
    public boolean validateCity(String cityName) {
        if(searchCityDataAccessObject.existsByName(cityName)) {
            return true;
        }
        return false;
    }
}

