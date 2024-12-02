package use_case.manage_sort;

import java.util.List;
import entity.CommonCity;

/**
 * Output data for the SortCities use case.
 */
public class SortCitiesOutputData {
    private final List<CommonCity> sortedCities;

    // 唯一input 是 sorted city data, 然后被存进此class
    public SortCitiesOutputData(List<CommonCity> sortedCities) {
        this.sortedCities = sortedCities;
    }

    public List<CommonCity> getSortedCities() {
        return sortedCities;
    }
}
