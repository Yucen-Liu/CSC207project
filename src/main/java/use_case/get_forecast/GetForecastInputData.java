package use_case.get_forecast;

import java.util.List;

/**
 * The Input Data for the GetHistory Use Case.
 */
public class GetForecastInputData {
    private final String cityName;
    private final List<String> savedCityNames;

    public GetForecastInputData(String cityName, List<String> savedCityNames) {
        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
    }

    public String getCityName() { return cityName;}

    public List<String> getSavedCityNames() { return savedCityNames;}

}
