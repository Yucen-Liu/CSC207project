package use_case.manage_sort;

import java.util.List;

/**
 * Input data for the SortCities use case.
 */

// InputData 唯一一个携带的东西就是 criterion, which is given by 'View' and through 'Controller' to give to 'InputData'
public class SortCitiesInputData {
    private final String criterion;
    private final List<String> savedCityNames;

    // When initializing the InputData class, we need one input which is a String we called criterion
    public SortCitiesInputData(String criterion, List<String> savedCityNames) {
        this.criterion = criterion;
        this.savedCityNames = savedCityNames;
    }

    public String getCriterion() {
        return criterion;
    }
    public List<String> getSavedCityNames() {return savedCityNames;}
}
