package use_case.get_history;

/**
 * The Input Data for the GetHistory Use Case.
 */
public class GetHistoryInputData {
    private final String cityName;
    public GetHistoryInputData(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() { return cityName;}

}
