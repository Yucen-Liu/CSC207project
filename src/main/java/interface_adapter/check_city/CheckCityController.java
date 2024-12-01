package interface_adapter.check_city;

import use_case.check_city.CheckCityInputBoundary;
import use_case.check_city.CheckCityInputData;

public class CheckCityController {
    private final CheckCityInputBoundary checkCityUseCaseInteractor;

    public CheckCityController(CheckCityInputBoundary interactor) {
        this.checkCityUseCaseInteractor = interactor;
    }

    public void execute(String cityName) {
        CheckCityInputData inputData = new CheckCityInputData(cityName);
        checkCityUseCaseInteractor.execute(inputData);
    }
}

