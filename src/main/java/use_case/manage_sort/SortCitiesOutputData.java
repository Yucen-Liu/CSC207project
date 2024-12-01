package use_case.manage_sort;

import java.util.List;
import entity.CommonCity;

/**
 * Output data for the SortCities use case.
 */
public class SortCitiesOutputData {
    private final List<CommonCity> sortedCities;

    public SortCitiesOutputData(List<CommonCity> sortedCities) {
        this.sortedCities = sortedCities;
    }

    public List<CommonCity> getSortedCities() {
        return sortedCities;
    }
}
