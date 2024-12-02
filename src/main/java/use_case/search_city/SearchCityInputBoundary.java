package use_case.search_city;


import java.util.List;

/**
 * Input Boundary for actions which are related to the home page.
 */
public interface SearchCityInputBoundary {

    /**
     * Executes the home use case.
     *
     * @param searchcityInputData the input data
     */
    void execute(SearchCityInputData searchcityInputData);
    void switchToGetDetailsView(String cityName);
    void switchToSortCitiesView(List<String> cityNames);
    boolean validateCity(String cityName);
}