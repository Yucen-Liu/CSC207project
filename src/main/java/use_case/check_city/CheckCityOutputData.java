package use_case.check_city;

/**
 * Output Data for the CheckCity Use Case.
 */
public class CheckCityOutputData {

    private final String cityName;
    private final boolean useCaseFailed;

    public CheckCityOutputData(String cityName, boolean useCaseFailed) {
        this.cityName = cityName;
        this.useCaseFailed = useCaseFailed;
    }

    public String getCityName() {
        return cityName;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
