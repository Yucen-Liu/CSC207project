package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory for creating ForecastCity objects.
 */
public class ForecastCityFactory implements CityFactory {
    @Override
    public ForecastCity create(String location, double temperature, String condition, int humidity) {
        List<String> initialThreeHoursAgo = new ArrayList<>();
        List<String> initialSixHoursAgo = new ArrayList<>();
        List<String> initialNineHoursAgo = new ArrayList<>();
        List<List<String>> weatherHistory = new ArrayList<>();
        weatherHistory.add(initialThreeHoursAgo);
        weatherHistory.add(initialSixHoursAgo);
        weatherHistory.add(initialNineHoursAgo);
        return new ForecastCity(location, temperature, condition, humidity, weatherHistory);
    }

    public ForecastCity create(String location, double temperature, String condition, int humidity,
                               List<List<String>> forecast) {
        return new ForecastCity(location,temperature,condition,humidity,forecast);
    }

    public ForecastCity addForecast (ForecastCity forecastCity, List<List<String>> forecast) {
        forecastCity.setForecast(forecast);
        return forecastCity;
    }

    public List<String> historyCertainHour(double temperature, String condition, int humidity) {
        String temp = String.valueOf(temperature);
        String hum = String.valueOf(humidity);
        List<String> weatherHistory = new ArrayList<>();
        weatherHistory.add(temp);
        weatherHistory.add(condition);
        weatherHistory.add(hum);
        return weatherHistory;
    }

}
