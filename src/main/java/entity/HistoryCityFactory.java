package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory for creating HistoryCity objects.
 */
public class HistoryCityFactory implements CityFactory {
    @Override
    public City create(String location, double temperature, String condition, int humidity) {
        List<String> initialThreeHoursAgo = new ArrayList<>();
        List<String> initialSixHoursAgo = new ArrayList<>();
        List<String> initialNineHoursAgo = new ArrayList<>();
        List<List<String>> weatherHistory = new ArrayList<>();
        weatherHistory.add(initialThreeHoursAgo);
        weatherHistory.add(initialSixHoursAgo);
        weatherHistory.add(initialNineHoursAgo);
        return new HistoryCity(location, temperature, condition, humidity, weatherHistory);
    }

    public City create(String location, double temperature, String condition, int humidity, List<List<String>> history) {
        return new HistoryCity(location,temperature,condition,humidity,history);
    }

    public List<String> HistoryCertainHour(double temperature, String condition, int humidity) {
        String temp = String.valueOf(temperature);
        String hum = String.valueOf(humidity);
        List<String> weatherHistory = new ArrayList<>();
        weatherHistory.add(temp);
        weatherHistory.add(condition);
        weatherHistory.add(hum);
        return weatherHistory;
    }

}
