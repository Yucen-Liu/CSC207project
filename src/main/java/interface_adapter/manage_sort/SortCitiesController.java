package interface_adapter.manage_sort;

import use_case.manage_sort.SortCitiesInputBoundary;
import use_case.manage_sort.SortCitiesInputData;

/**
 * Controller for the SortCities use case.
 */
public class SortCitiesController {

    private final SortCitiesInputBoundary inputBoundary;

    public SortCitiesController(SortCitiesInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Handles the sort request by passing input data to the interactor.
     *
     * @param criterion The criterion to sort by (e.g., temperature, condition, humidity).
     */
    public void handleSortRequest(String criterion) {
        SortCitiesInputData inputData = new SortCitiesInputData(criterion);
        inputBoundary.sort(inputData);
    }
}
