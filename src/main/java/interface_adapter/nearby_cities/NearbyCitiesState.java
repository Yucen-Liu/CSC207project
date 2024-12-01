package interface_adapter.nearby_cities;

import java.util.ArrayList;
import java.util.List;

public class NearbyCitiesState {
    private String cityName = "";
    private List<String> nearbyCityNames = new ArrayList<String>();
    private List<Double> nearbyCityTemperatures = new ArrayList<>();
    private List<String> nearbyCityConditions = new ArrayList<>();
    private List<Integer> nearbyCityHumidities = new ArrayList<>();

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<String> getNearbyCityNames() {
        return nearbyCityNames;
    }

    public void setNearbyCityNames(List<String> nearbyCityNames) {
        this.nearbyCityNames = nearbyCityNames;
    }

    public List<Double> getNearbyCityTemperatures() {
        return nearbyCityTemperatures;
    }

    public void setNearbyCityTemperatures(List<Double> nearbyCityTemperatures) {
        this.nearbyCityTemperatures = nearbyCityTemperatures;
    }

    public List<String> getNearbyCityConditions() {
        return nearbyCityConditions;
    }

    public void setNearbyCityConditions(List<String> nearbyCityConditions) {
        this.nearbyCityConditions = nearbyCityConditions;
    }

    public List<Integer> getNearbyCityHumidities() {
        return nearbyCityHumidities;
    }

    public void setNearbyCityHumidities(List<Integer> nearbyCityHumidities) {
        this.nearbyCityHumidities = nearbyCityHumidities;
    }
}
