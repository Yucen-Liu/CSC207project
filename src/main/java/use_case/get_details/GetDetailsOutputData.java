package use_case.get_details;

import java.util.List;

public class GetDetailsOutputData {
    private final String cityName;
    private final List<String> savedCityNames;

    private final int temperture;
    private final String condition;
    private final double humidity;

    private final boolean useCaseFailed;

    public GetDetailsOutputData(String cityName, List<String> savedCityNames,
                                int temperature, String condition, double humidity,
                                boolean useCaseFailed) {
        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
        this.temperture = temperature;
        this.condition = condition;
        this.humidity = humidity;
        this.useCaseFailed = useCaseFailed;
    }
    public String getCityName() {return cityName;}
    public List<String> getSavedCityNames() {return savedCityNames;}

    public int getTemperature() {return temperture;}
    public String getCondition() {return condition;}
    public double getHumidity() {return humidity;}

    public boolean isUseCaseFailed() {return useCaseFailed;}
}
