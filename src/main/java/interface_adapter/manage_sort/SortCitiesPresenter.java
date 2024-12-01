package interface_adapter.manage_sort;

import use_case.manage_sort.SortCitiesOutputBoundary;
import java.util.List;

/**
 * Presenter for the sort cities use case.
 */
public class SortCitiesPresenter implements SortCitiesOutputBoundary {
    private List<String> sortedCities;

    /**
     * Presents the sorted list of cities.
     * @param sortedCities the list of sorted cities.
     */
    @Override
    public void presentSortedCities(List<String> sortedCities) {
        this.sortedCities = sortedCities;
    }

    /**
     * Returns the sorted cities list.
     * This method can be used by the view to update the display.
     * @return the sorted list of cities.
     */
    public List<String> getSortedCities() {
        return sortedCities;
    }
}
