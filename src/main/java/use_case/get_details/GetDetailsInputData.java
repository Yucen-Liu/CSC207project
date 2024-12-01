package use_case.get_details;

import java.util.List;

/**
 * The Input Data for the GetDetails Use Case.
 */
public class GetDetailsInputData {

    private final String cityName;
    private final List<String> savedCityNames;

    public GetDetailsInputData(String cityName, List<String> savedCityNames) {
        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
    }

    public String getCityName() { return cityName;}

    public List<String> getSavedCityNames() { return savedCityNames;}
}
