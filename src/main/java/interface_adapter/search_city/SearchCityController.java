package interface_adapter.search_city;

import interface_adapter.get_details.GetDetailsState;
import interface_adapter.get_details.GetDetailsViewModel;
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

    public boolean isValidCityName(String cityName) {
        return this.searchCityUseCaseInteractor.validateCity(cityName);
    }

    public SearchCityViewModel getSearchCityViewModel() { return searchCityViewModel; }
    public void switchToGetDetailsView(String selectedCity) {
        searchCityUseCaseInteractor.switchToGetDetailsView(selectedCity);
    }
    public void switchToSortCitiesView(List<String> savedCityNames) {
        searchCityUseCaseInteractor.switchToSortCitiesView(savedCityNames);
    }
}
