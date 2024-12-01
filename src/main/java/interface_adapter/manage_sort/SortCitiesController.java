package interface_adapter.manage_sort;

import use_case.manage_sort.SortCitiesInputBoundary;

/**
 * Controller for the sort cities use case.
 */
public class SortCitiesController {
    private final SortCitiesInputBoundary inputBoundary;

    public SortCitiesController(SortCitiesInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Passes the sort request to the input boundary.
     * @param sortBy the criteria to sort by (e.g., temperature, condition, humidity).
     */
    public void sortCities(String sortBy) {
        inputBoundary.sortCities(sortBy);
    }
}
