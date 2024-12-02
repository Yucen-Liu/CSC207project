package entity;

public class DetailedCity implements City{
    private final String location;
    private final double temperature;
    private final String condition;
    private final int humidity;
    private final double temp_min;
    private final double temp_max;
    private final int visibility;
    private final int pressure;

    public DetailedCity(String location, double temperature, String condition, int humidity, double temp_max,
                        double temp_min, int pressure, int visibility) {
        this.location = location;
        this.temperature = temperature;
        this.condition = condition;
        this.humidity = humidity;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.pressure = pressure;
        this.visibility = visibility;

    }

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

    public double getTempMin() {return temp_min;}
    public double getTempMax() {return temp_max;}
    public int getVisibility() {return visibility;}
    public int getPressure() {return pressure;}
}
