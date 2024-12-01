package use_case.manage_sort;

import java.util.List;

/**
 * Output boundary for the sort cities use case.
 */
public interface SortCitiesOutputBoundary {
    /**
     * Presents the sorted list of cities.
     * @param sortedCities the list of sorted cities.
     */
    void presentSortedCities(List<String> sortedCities);
}
