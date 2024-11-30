package use_case.search_city;

/**
 * Output Data for the CheckCity Use Case.
 */
public class SearchCityOutputData {

    private final String cityname;
    private final boolean useCaseFailed;

    public SearchCityOutputData(String cityname, boolean useCaseFailed) {
        this.cityname = cityname;
        this.useCaseFailed = useCaseFailed;
    }

    public String getCityname() {
        return cityname;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}