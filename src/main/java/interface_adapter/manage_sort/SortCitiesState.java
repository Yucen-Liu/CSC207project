package interface_adapter.manage_sort;

import entity.CommonCity;
import java.util.List;

/**
 * State for managing the sorted cities.
 */
public class SortCitiesState {

    private List<String> cityNames;
    private List<CommonCity> sortedCities;

    public List<CommonCity> getSortedCities() {
        return sortedCities;
    }

    public List<String> getCityNames() {
        return cityNames;
    }
    public void setCityNames(List<String> cityNames) {}

    public void setSortedCities(List<CommonCity> sortedCities) {
        this.sortedCities = sortedCities;
    }
}
