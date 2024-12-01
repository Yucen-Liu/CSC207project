package use_case.manage_sort;

import java.util.List;
import use_case.manage_sort.SortCitiesOutputData;

/**
 * Output boundary for the SortCities use case.
 */
public interface SortCitiesOutputBoundary {
    /**
     * Prepares the sorted cities for output.
     *
     * @param outputData The sorted cities data.
     */
    void presentSortedCities(SortCitiesOutputData outputData);
}
