package org.weatherapp.use_cases;

public interface WeatherOutputBoundary {
    WeatherInformation toDisplay(WeatherInformation weatherInformation);
}
