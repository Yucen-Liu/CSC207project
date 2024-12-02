package use_case.search_city;

/**
 * The output boundary for the CheckCity Use Case.
 */
public interface SearchCityOutputBoundary {
    void searchCityInformationView(SearchCityOutputData searchCityOutputData);
    void switchToGetDetailsView(String cityName);
    void switchToSortCitiesView();
}