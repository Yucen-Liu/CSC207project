package use_case.get_history;

/**
 * The Input Data for the GetHistory Use Case.
 */
public class GetHistoryInputData {
    private final String cityname;
    public GetHistoryInputData(String cityname) {
        this.cityname = cityname;
    }

    public String getCityname() { return cityname;}

}
