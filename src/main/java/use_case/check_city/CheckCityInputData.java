package use_case.check_city;

/**
 * The Input Data for the CheckCity Use Case.
 */
public class CheckCityInputData {

    private final String cityname;

    public CheckCityInputData(String cityname) {
        this.cityname = cityname;
    }

    public String getCityname() { return cityname; }
}
