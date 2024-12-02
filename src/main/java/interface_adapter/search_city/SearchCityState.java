package interface_adapter.search_city;

import java.util.List;

public class SearchCityState {
    private String location;
    private Double temperature;
    private String condition;
    private int humidity;
    private List<String> savedCityNames;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public List<String> getSavedCityNames() {
        return savedCityNames;
    }

    public void setSavedCityNames(List<String> savedCityNames) {
        this.savedCityNames = savedCityNames;
    }
}
