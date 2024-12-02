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
        SortCitiesInputData inputData = new SortCitiesInputData(criterion); // 从用户界面(View)中，比如用户点击了 Temperature as criterion，就生成一个新的inputdata并给他criterion
        inputBoundary.sort(inputData);
    }
}
