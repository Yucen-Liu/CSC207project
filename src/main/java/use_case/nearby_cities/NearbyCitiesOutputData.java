package use_case.nearby_cities;

import java.util.List;

public class NearbyCitiesOutputData {
    private final String cityName;
    private final List<String> savedCityNames;

    public NearbyCitiesOutputData(String cityName, List<String> savedCityNames) {
        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
    }
}
