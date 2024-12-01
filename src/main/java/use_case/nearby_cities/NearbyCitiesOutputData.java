package use_case.nearby_cities;

import entity.NearbyCity;

import java.util.List;

public class NearbyCitiesOutputData {
    private final String cityName;
    private final List<String> savedCityNames;
    private final List<NearbyCity> nearbyCities;

    public NearbyCitiesOutputData(List<NearbyCity> nearbyCities, String cityName, List<String> savedCityNames) {
        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
        this.nearbyCities = nearbyCities;
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
}
