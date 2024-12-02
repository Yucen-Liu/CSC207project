package use_case.nearby_cities;

import entity.NearbyCity;

import java.util.ArrayList;
import java.util.List;

public class NearbyCitiesOutputData {
    private final String cityName;
    private final List<String> savedCityNames;
    private final List<NearbyCity> nearbyCities;

    private final List<String> nearbyCityNames;
    private final List<Double> nearbyCitiesTemperature;
    private final List<String> nearbyCitiesCondition;
    private final List<Integer> nearbyCitiesHumidity;

    public NearbyCitiesOutputData(List<NearbyCity> nearbyCities, String cityName, List<String> savedCityNames) {
        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
        this.nearbyCities = nearbyCities;
        this.nearbyCityNames = new ArrayList<>();
        this.nearbyCitiesTemperature = new ArrayList<>();
        this.nearbyCitiesCondition = new ArrayList<>();
        this.nearbyCitiesHumidity = new ArrayList<>();

        for(int i=0; i<nearbyCities.size(); i++) {
            this.nearbyCityNames.add(nearbyCities.get(i).getLocation());
            this.nearbyCitiesTemperature.add(nearbyCities.get(i).getTemperature());
            this.nearbyCitiesCondition.add(nearbyCities.get(i).getCondition());
            this.nearbyCitiesHumidity.add(nearbyCities.get(i).getHumidity());
        }
    }

    public String getCityName() {
        return cityName;
    }

    public List<String> getSavedCityNames() {
        return savedCityNames;
    }

    public List<NearbyCity> getNearbyCities() {
        return nearbyCities;
    }

    public List<String> getNearbyCityNames(){ return nearbyCityNames; }
    public List<Double> getNearbyCitiesTemperature() { return nearbyCitiesTemperature; }
    public List<String> getNearbyCitiesCondition() { return nearbyCitiesCondition; }
    public List<Integer> getNearbyCitiesHumidity() { return nearbyCitiesHumidity; }
}
