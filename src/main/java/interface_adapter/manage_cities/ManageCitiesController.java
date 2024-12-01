package interface_adapter.manage_cities;

import use_case.cities.ManageCitiesInteractor;

import java.util.List;

public class ManageCitiesController {
    private final ManageCitiesInteractor manageCitiesInteractor;

    public ManageCitiesController(ManageCitiesInteractor manageCitiesInteractor) {
        this.manageCitiesInteractor = manageCitiesInteractor;
    }

    public List<String> getCities() {
        return manageCitiesInteractor.getCities();
    }

    public boolean addCity(String cityName) {
        return manageCitiesInteractor.addCity(cityName);
    }

    public boolean removeCity(String cityName) {
        return manageCitiesInteractor.removeCity(cityName);
    }
}
