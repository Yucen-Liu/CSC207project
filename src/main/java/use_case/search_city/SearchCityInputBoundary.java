package use_case.search_city;

import use_case.check_city.CheckCityInputData;

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
}