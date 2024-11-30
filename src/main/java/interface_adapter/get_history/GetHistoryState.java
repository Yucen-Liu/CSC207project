package interface_adapter.get_history;

import java.util.ArrayList;
import java.util.List;

/**
 * The state for the GetHistory View Model.
 */
public class GetHistoryState {
    private String cityName = "";
    private List<String> savedCityNames = new ArrayList<>();

    private String temperatureThreeHoursAgo = "";
    private String conditionThreeHoursAgo = "";
    private String humidityThreeHoursAgo = "";

    private String temperatureSixHoursAgo = "";
    private String conditionSixHoursAgo = "";
    private String humiditySixHoursAgo = "";

    private String temperatureNineHoursAgo = "";
    private String conditionNineHoursAgo = "";
    private String humidityNineHoursAgo = "";

    public String getCityName() {return cityName;}
    public void setCityName(String cityName) {this.cityName = cityName;}
    public List<String> getSavedCityNames() {return savedCityNames;}
    public void setSavedCityNames(List<String> savedCityNames) {}

    public String getTemperatureThreeHoursAgo() {return temperatureThreeHoursAgo;}
    public String getConditionThreeHoursAgo() {return conditionThreeHoursAgo;}
    public String getHumidityThreeHoursAgo() {return humidityThreeHoursAgo;}

    public String getTemperatureSixHoursAgo() {return temperatureSixHoursAgo;}
    public String getConditionSixHoursAgo() {return conditionSixHoursAgo;}
    public String getHumiditySixHoursAgo() {return humiditySixHoursAgo;}

    public String getTemperatureNineHoursAgo() {return temperatureNineHoursAgo;}
    public String getConditionNineHoursAgo() {return conditionNineHoursAgo;}
    public String getHumidityNineHoursAgo() {return humidityNineHoursAgo;}

    public void setTemperatureThreeHoursAgo(String temperatureThreeHoursAgo) {
        this.temperatureThreeHoursAgo = temperatureThreeHoursAgo;
    }
    public void setConditionThreeHoursAgo(String conditionThreeHoursAgo) {
        this.conditionThreeHoursAgo = conditionThreeHoursAgo;
    }
    public void setHumidityThreeHoursAgo(String humidityThreeHoursAgo) {
    this.humidityThreeHoursAgo = humidityThreeHoursAgo;
    }

    public void setTemperatureSixHoursAgo(String temperatureSixHoursAgo) {
        this.temperatureSixHoursAgo = temperatureSixHoursAgo;
    }
    public void setConditionSixHoursAgo(String conditionSixHoursAgo) {
        this.conditionSixHoursAgo = conditionSixHoursAgo;
    }
    public void setHumiditySixHoursAgo(String humiditySixHoursAgo) {
        this.humiditySixHoursAgo = humiditySixHoursAgo;
    }

    public void setTemperatureNineHoursAgo(String temperatureNineHoursAgo) {
        this.temperatureNineHoursAgo = temperatureNineHoursAgo;
    }
    public void setConditionNineHoursAgo(String conditionNineHoursAgo) {
        this.conditionNineHoursAgo = conditionNineHoursAgo;
    }
    public void setHumidityNineHoursAgo(String humidityNineHoursAgo) {
        this.humidityNineHoursAgo = humidityNineHoursAgo;
    }
}
