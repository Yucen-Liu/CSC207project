package interface_adapter.get_forecast;

import java.util.ArrayList;
import java.util.List;

/**
 * The state for the GetHistory View Model.
 */
public class GetForecastState {
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

    public String getTemperatureThreeHoursAgo() {return temperatureThreeHoursAgo;}
    public String getConditionThreeHoursAgo() {return conditionThreeHoursAgo;}
    public String getHumidityThreeHoursAgo() {return humidityThreeHoursAgo;}

    public String getTemperatureSixHoursAgo() {return temperatureSixHoursAgo;}
    public String getConditionSixHoursAgo() {return conditionSixHoursAgo;}
    public String getHumiditySixHoursAgo() {return humiditySixHoursAgo;}

    public String getTemperatureNineHoursAgo() {return temperatureNineHoursAgo;}
    public String getConditionNineHoursAgo() {return conditionNineHoursAgo;}
    public String getHumidityNineHoursAgo() {return humidityNineHoursAgo;}

    public void setTemperatureThreeHoursLater(String temperatureThreeHoursAgo) {
        this.temperatureThreeHoursAgo = temperatureThreeHoursAgo;
    }
    public void setConditionThreeHoursLater(String conditionThreeHoursAgo) {
        this.conditionThreeHoursAgo = conditionThreeHoursAgo;
    }
    public void setHumidityThreeHoursLater(String humidityThreeHoursAgo) {
    this.humidityThreeHoursAgo = humidityThreeHoursAgo;
    }

    public void setTemperatureSixHoursLater(String temperatureSixHoursAgo) {
        this.temperatureSixHoursAgo = temperatureSixHoursAgo;
    }
    public void setConditionSixHoursLater(String conditionSixHoursAgo) {
        this.conditionSixHoursAgo = conditionSixHoursAgo;
    }
    public void setHumiditySixHoursLater(String humiditySixHoursAgo) {
        this.humiditySixHoursAgo = humiditySixHoursAgo;
    }

    public void setTemperatureNineHoursLater(String temperatureNineHoursAgo) {
        this.temperatureNineHoursAgo = temperatureNineHoursAgo;
    }
    public void setConditionNineHoursLater(String conditionNineHoursAgo) {
        this.conditionNineHoursAgo = conditionNineHoursAgo;
    }
    public void setHumidityNineHoursLater(String humidityNineHoursAgo) {
        this.humidityNineHoursAgo = humidityNineHoursAgo;
    }
}
