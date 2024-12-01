package use_case.get_details;

import java.util.List;

public class GetDetailsOutputData {
    private final String cityName;
    private final List<String> savedCityNames;

    private final double temperature;
    private final String condition;
    private final int humidity;

    private double temp_min;
    private double temp_max;
    private int pressure;
    private int visibility;

    private final boolean useCaseFailed;

    public GetDetailsOutputData(String cityName, List<String> savedCityNames,
                                double temperature, String condition, int humidity, double temp_min, double temp_max,
                                int pressure, int visibility, boolean useCaseFailed) {
        this.cityName = cityName;
        this.savedCityNames = savedCityNames;

        this.temperature = temperature;
        this.condition = condition;
        this.humidity = humidity;

        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.visibility = visibility;

        this.useCaseFailed = useCaseFailed;
    }
    public String getCityName() {return cityName;}
    public List<String> getSavedCityNames() {return savedCityNames;}

    public double getTemperature() {return temperature;}
    public String getCondition() {return condition;}
    public int getHumidity() {return humidity;}

    public double getTemp_min() {return temp_min;}
    public double getTemp_max() {return temp_max;}
    public int getPressure() {return pressure;}
    public int getVisibility() {return visibility;}

    public boolean isUseCaseFailed() {return useCaseFailed;}
}
