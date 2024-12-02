package interface_adapter.search_city;

import use_case.search_city.SearchCityInputBoundary;
import use_case.search_city.SearchCityInputData;

import java.util.List;

public class SearchCityController {
    private final SearchCityInputBoundary searchCityUseCaseInteractor;
    private final SearchCityViewModel searchCityViewModel;

    public SearchCityController(SearchCityInputBoundary searchCityUseCaseInteractor,
                                SearchCityViewModel searchCityViewModel) {
        this.searchCityUseCaseInteractor = searchCityUseCaseInteractor;
        this.searchCityViewModel = searchCityViewModel;
    }

    public void execute(String cityName, List<String> savedCityNames) {
        final SearchCityInputData searchCityInputData = new SearchCityInputData(cityName, savedCityNames);
        searchCityUseCaseInteractor.execute(searchCityInputData);
    }

    public SearchCityViewModel getSearchCityViewModel() { return searchCityViewModel; }
}
