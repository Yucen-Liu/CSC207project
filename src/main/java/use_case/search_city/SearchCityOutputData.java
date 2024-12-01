package use_case.search_city;

import java.util.List;

/**
 * Output Data for the CheckCity Use Case.
 */
public class SearchCityOutputData {
    private final String cityName;
    private final List<String> savedCityNames;
    private final double temperature;
    private final String condition;
    private final int humidity;
    private final boolean useCaseFailed;

    public SearchCityOutputData(String cityName, List<String> savedCityNames, double temperature, String condition,
                                int humidity, boolean useCaseFailed) {
        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
        this.temperature = temperature;
        this.condition = condition;
        this.humidity = humidity;
        this.useCaseFailed = useCaseFailed;
    }

    public String getCityName() {
        return cityName;
    }

    public List<String> getSavedCityNames() {
        return savedCityNames;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    public int getHumidity() {
        return humidity;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}