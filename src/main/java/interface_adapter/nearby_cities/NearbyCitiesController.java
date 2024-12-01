package interface_adapter.nearby_cities;

import use_case.get_forecast.GetForecastInputData;
import use_case.nearby_cities.NearbyCitiesInputBoundary;
import use_case.nearby_cities.NearbyCitiesInputData;

import java.util.List;

public class NearbyCitiesController {
    private final NearbyCitiesInputBoundary nearbyCitiesUseCaseInteractor;

    public NearbyCitiesController(NearbyCitiesInputBoundary nearbyCitiesUseCaseInteractor) {
        this.nearbyCitiesUseCaseInteractor = nearbyCitiesUseCaseInteractor;
    }

    public void execute(String cityName, List<String> savedCityNames) {
        final NearbyCitiesInputData nearbyCitiesInputData = new NearbyCitiesInputData(cityName, savedCityNames);
        nearbyCitiesUseCaseInteractor.execute(nearbyCitiesInputData);
    }

    public void switchGetDetailsView() {
        nearbyCitiesUseCaseInteractor.switchToGetDetailsView();
    }
}
