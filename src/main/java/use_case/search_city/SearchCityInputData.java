package use_case.search_city;

/**
 * The Input Data for the SearchCity Use Case.
 */
public class SearchCityInputData {

    private final String cityname;

    public SearchCityInputData(String cityname) {
        this.cityname = cityname;
    }

    public String getCityname() { return cityname; }
}
