package use_case.cities;

import data_access.CityStorage;

import java.util.List;

public class ManageCitiesInteractor {
    private final CityStorage cityStorage;

    public ManageCitiesInteractor(CityStorage cityStorage) {
        this.cityStorage = cityStorage;
    }

    public List<String> getCities() {
        return cityStorage.loadCities();
    }

    public boolean addCity(String cityName) {
        return cityStorage.addCity(cityName);
    }

    public boolean removeCity(String cityName) {
        return cityStorage.removeCity(cityName);
    }

    public boolean isCityValid(String cityName) {
        // Ensure the city name is not null, not empty, and meets specific criteria
        return cityName != null && !cityName.trim().isEmpty() && cityName.matches("^[a-zA-Z\\s]+$");
    }


}
