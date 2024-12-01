package interface_adapter.manage_sort;

import entity.CommonCity;
import java.util.List;

/**
 * State for managing the sorted cities.
 */
public class SortCitiesState {

    private List<CommonCity> sortedCities;

    public List<CommonCity> getSortedCities() {
        return sortedCities;
    }

    public void setSortedCities(List<CommonCity> sortedCities) {
        this.sortedCities = sortedCities;
    }
}
