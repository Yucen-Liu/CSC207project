package org.weatherapp.presenter;

import org.weatherapp.use_cases.WeatherInformation;
import org.weatherapp.use_cases.WeatherOutputBoundary;

public class WeatherOutputPresenter implements WeatherOutputBoundary {

    @Override
    public WeatherInformation toDisplay(WeatherInformation weatherInformation) {
        return weatherInformation;
    }
}
