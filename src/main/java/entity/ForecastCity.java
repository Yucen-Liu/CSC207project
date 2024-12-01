package entity;

import java.util.List;

/**
 * An implementation of the City interface with the weather history of city during tha past nine hours.
 */
public class ForecastCity implements City {
    private final String location;
    private final double temperature;
    private final String condition;
    private final int humidity;

    private List<List<String>> forecast;

    public ForecastCity(String location, double temperature, String condition, int humidity, List<List<String>> weatherForecast) {
        this.location = location;
        this.temperature = temperature;
        this.condition = condition;
        this.humidity = humidity;
        this.forecast = weatherForecast;
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

    public List<List<String>> getForecast() {
        return forecast;
    }

    public void setForecast(List<List<String>> forecast) {
        this.forecast = forecast;
    }
}
