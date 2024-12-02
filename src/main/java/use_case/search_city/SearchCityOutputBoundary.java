package use_case.search_city;

import java.util.List;

/**
 * The output boundary for the CheckCity Use Case.
 */
public interface SearchCityOutputBoundary {
    void searchCityInformationView(SearchCityOutputData searchCityOutputData);
    void switchToGetDetailsView(String cityName);
    void switchToSortCitiesView(List<String> savedCityNames);
}