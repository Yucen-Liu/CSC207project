package interface_adapter.get_forecast;

import java.util.ArrayList;
import java.util.List;

/**
 * The state for the GetForecast View Model.
 */
public class GetForecastState {
    private String cityName = "";
    private List<String> savedCityNames = new ArrayList<>();

    private String temperatureThreeHoursLater = "";
    private String conditionThreeHoursLater = "";
    private String humidityThreeHoursLater = "";

    private String temperatureSixHoursLater = "";
    private String conditionSixHoursLater = "";
    private String humiditySixHoursLater = "";

    private String temperatureNineHoursLater = "";
    private String conditionNineHoursLater = "";
    private String humidityNineHoursLater = "";

    // Getters and Setters
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<String> getSavedCityNames() {
        return savedCityNames;
    }

    public void setSavedCityNames(List<String> savedCityNames) {
        this.savedCityNames = savedCityNames;
    }

    public String getTemperatureThreeHoursLater() {
        return temperatureThreeHoursLater;
    }

    public void setTemperatureThreeHoursLater(String temperatureThreeHoursLater) {
        this.temperatureThreeHoursLater = temperatureThreeHoursLater;
    }

    public String getConditionThreeHoursLater() {
        return conditionThreeHoursLater;
    }

    public void setConditionThreeHoursLater(String conditionThreeHoursLater) {
        this.conditionThreeHoursLater = conditionThreeHoursLater;
    }

    public String getHumidityThreeHoursLater() {
        return humidityThreeHoursLater;
    }

    public void setHumidityThreeHoursLater(String humidityThreeHoursLater) {
        this.humidityThreeHoursLater = humidityThreeHoursLater;
    }

    public String getTemperatureSixHoursLater() {
        return temperatureSixHoursLater;
    }

    public void setTemperatureSixHoursLater(String temperatureSixHoursLater) {
        this.temperatureSixHoursLater = temperatureSixHoursLater;
    }

    public String getConditionSixHoursLater() {
        return conditionSixHoursLater;
    }

    public void setConditionSixHoursLater(String conditionSixHoursLater) {
        this.conditionSixHoursLater = conditionSixHoursLater;
    }

    public String getHumiditySixHoursLater() {
        return humiditySixHoursLater;
    }

    public void setHumiditySixHoursLater(String humiditySixHoursLater) {
        this.humiditySixHoursLater = humiditySixHoursLater;
    }

    public String getTemperatureNineHoursLater() {
        return temperatureNineHoursLater;
    }

    public void setTemperatureNineHoursLater(String temperatureNineHoursLater) {
        this.temperatureNineHoursLater = temperatureNineHoursLater;
    }

    public String getConditionNineHoursLater() {
        return conditionNineHoursLater;
    }

    public void setConditionNineHoursLater(String conditionNineHoursLater) {
        this.conditionNineHoursLater = conditionNineHoursLater;
    }

    public String getHumidityNineHoursLater() {
        return humidityNineHoursLater;
    }

    public void setHumidityNineHoursLater(String humidityNineHoursLater) {
        this.humidityNineHoursLater = humidityNineHoursLater;
    }
}
