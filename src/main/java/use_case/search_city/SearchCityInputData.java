package use_case.search_city;

import java.util.List;

/**
 * The Input Data for the SearchCity Use Case.
 */
public class SearchCityInputData {
    private final String cityName;
    private final List<String> savedCityNames;

    public SearchCityInputData(String cityName, List<String> savedCityNames) {
        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
    }

    public String getCityname() { return cityName; }
    public List<String> getSavedCityNames() { return savedCityNames; }
}
