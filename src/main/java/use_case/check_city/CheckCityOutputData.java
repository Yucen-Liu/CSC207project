package use_case.check_city;

/**
 * Output Data for the CheckCity Use Case.
 */
public class CheckCityOutputData {

    private final String cityname;
    private final boolean useCaseFailed;

    public CheckCityOutputData(String cityname, boolean useCaseFailed) {
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
