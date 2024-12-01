package use_case.check_city;

/**
 * Input Data for the CheckCity Use Case.
 */
public class CheckCityInputData {
    private final String cityName;

    public CheckCityInputData(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
