package use_case.manage_sort;

/**
 * Input boundary for the SortCities use case.
 */
public interface SortCitiesInputBoundary {
    /**
     * Sort the saved cities based on the given criterion.
     *
     * @param inputData The input data containing the sort criterion.
     */

    // The only function we have here is sort (InputData)
    void sort(SortCitiesInputData inputData);
}
