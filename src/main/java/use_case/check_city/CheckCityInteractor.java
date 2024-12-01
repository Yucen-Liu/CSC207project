package use_case.check_city;

import data_access.CurWeatherInfo;

public class CheckCityInteractor implements CheckCityInputBoundary {
    private final CurWeatherInfo weatherInfo;
    private final CheckCityOutputBoundary outputBoundary;

    public CheckCityInteractor(CurWeatherInfo weatherInfo, CheckCityOutputBoundary outputBoundary) {
        this.weatherInfo = weatherInfo;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public boolean validateCity(String cityName) {
        if (weatherInfo.existsByName(cityName)) {
            outputBoundary.presentSuccess(cityName);
            return true;
        } else {
            outputBoundary.presentFailure("City not found: " + cityName);
            return false;
        }
    }

    @Override
    public void execute(CheckCityInputData inputData) {
        validateCity(inputData.getCityName());
    }
}
