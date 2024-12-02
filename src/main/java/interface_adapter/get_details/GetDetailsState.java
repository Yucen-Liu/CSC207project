package interface_adapter.get_details;

import java.util.ArrayList;
import java.util.List;

public class GetDetailsState {

    private String cityName = "";
    private List<String> savedCityNames = new ArrayList<>();

    double temperature;
    String condition;
    int humidity;

    double temp_min;
    double temp_max;
    int pressure;
    int visibility;

    public String getCityName() {return cityName;}
    public void setCityName(String cityName) {this.cityName = cityName;}
    public List<String> getSavedCityNames() {return savedCityNames;}
    public void setSavedCityNames(List<String> savedCityNames) {this.savedCityNames = savedCityNames;}
    public double getTemperature() {return temperature;}
    public void setTemperature(double temperature) {this.temperature = temperature;}
    public String getCondition() {return condition;}
    public void setCondition(String condition) {this.condition = condition;}
    public int getHumidity() {return humidity;}
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public double getTemp_min() {return temp_min;}
    public void setTempMin(double temp_min) {
        this.temp_min = temp_min;
    }
    public double getTemp_max() {return temp_max;}
    public void setTempMax(double temp_max) {
        this.temp_max = temp_max;
    }
    public int getPressure() {return pressure;}
    public void setPressure(int pressure) {this.pressure = pressure;}
    public int getVisibility() {return visibility;}
    public void setVisibility(int visibility) {this.visibility = visibility;}

}
