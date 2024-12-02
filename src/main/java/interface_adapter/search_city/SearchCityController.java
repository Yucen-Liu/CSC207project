package interface_adapter.search_city;

import use_case.search_city.SearchCityInputBoundary;
import use_case.search_city.SearchCityInputData;

import java.util.List;

public class SearchCityController {
    private final SearchCityInputBoundary searchCityUseCaseInteractor;

    public SearchCityController(SearchCityInputBoundary searchCityUseCaseInteractor) {
        this.searchCityUseCaseInteractor = searchCityUseCaseInteractor;
    }

    public void execute(String cityName, List<String> savedCityNames) {
        final SearchCityInputData searchCityInputData = new SearchCityInputData(cityName, savedCityNames);
        searchCityUseCaseInteractor.execute(searchCityInputData);
    }
}
