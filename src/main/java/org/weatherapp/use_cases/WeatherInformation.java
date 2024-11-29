package org.weatherapp.use_cases;

public class WeatherInformation {
    private String location;
    private double temperature;
    private String condition;
    private int humidity;

    // Getters and Setters
    public String getLocation() { return location; }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
