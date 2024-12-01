package use_case.nearby_cities;

import java.util.List;

public class NearbyCitiesInputData {
    private final String cityName;
    private final List<String> savedCityNames;

    public NearbyCitiesInputData(String cityName, List<String> savedCityNames) {
        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
    }

    public String getCityName() { return cityName;}

    public List<String> getSavedCityNames() { return savedCityNames;}
}
