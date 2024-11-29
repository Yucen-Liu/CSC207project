package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the City interface with the weather history of city during tha past nine hours.
 */
public class HistoryCity implements City {
    private final String location;
    private final double temperature;
    private final String condition;
    private final int humidity;

    private final List<List<String>>  history;

    public static List<String> HistoryCertainHour(double temperature, String condition, int humidity) {
        String temp = String.valueOf(temperature);
        String hum = String.valueOf(humidity);
        List<String> history = new ArrayList<>();
        history.add(temp);
        history.add(condition);
        history.add(hum);
        return history;
    }

    public HistoryCity(String location, double temperature, String condition, int humidity, List<String> threeHoursAgo,
                       List<String> sixHoursAgo, List<String> nineHoursAgo) {
        this.location = location;
        this.temperature = temperature;
        this.condition = condition;
        this.humidity = humidity;


        List<List<String>> weatherHistory = new ArrayList<>();
        weatherHistory.add(threeHoursAgo);
        weatherHistory.add(sixHoursAgo);
        weatherHistory.add(nineHoursAgo);
        this.history = weatherHistory;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public String getCondition() {
        return condition;
    }

    @Override
    public int getHumidity() {
        return humidity;
    }

    public List<List<String>> getHistory() {
        return history;
    }
}
