package entity;

import java.io.Serializable;

/**
 * An implementation of the City interface.
 */
public class CommonCity implements City{
    private final String location;
    private final float temperature;
    private final String condition;
    private final int humidity;

    public CommonCity(String location, float temperature, String condition, int humidity) {
        this.location = location;
        this.temperature = temperature;
        this.condition = condition;
        this.humidity = humidity;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public float getTemperature() {
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

}
