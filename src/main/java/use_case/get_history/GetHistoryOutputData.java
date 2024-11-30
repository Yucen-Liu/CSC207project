package use_case.get_history;

import java.util.List;

/**
 * Output Data for the GetHistory Use Case.
 */
public class GetHistoryOutputData {

    private final String cityName;
    private final List<String> savedCityNames;

    private final String temperatureThreeHoursAgo;
    private final String conditionThreeHoursAgo;
    private final String humidityThreeHoursAgo;

    private final String temperatureSixHoursAgo;
    private final String conditionSixHoursAgo;
    private final String humiditySixHoursAgo;

    private final String temperatureNineHoursAgo;
    private final String conditionNineHoursAgo;
    private final String humidityNineHoursAgo;

    private final boolean useCaseFailed;

    public GetHistoryOutputData (List<List<String>> weatherHistory, String cityName, List<String> savedCityNames, boolean useCaseFailed) {
        this.temperatureThreeHoursAgo = weatherHistory.get(0).get(0);
        this.conditionThreeHoursAgo = weatherHistory.get(0).get(1);
        this.humidityThreeHoursAgo = weatherHistory.get(0).get(2);

        this.temperatureSixHoursAgo = weatherHistory.get(1).get(0);
        this.conditionSixHoursAgo = weatherHistory.get(1).get(1);
        this.humiditySixHoursAgo = weatherHistory.get(1).get(2);

        this.temperatureNineHoursAgo = weatherHistory.get(2).get(0);
        this.conditionNineHoursAgo = weatherHistory.get(2).get(1);
        this.humidityNineHoursAgo = weatherHistory.get(2).get(2);

        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTemperatureThreeHoursAgo() {return temperatureThreeHoursAgo;}
    public String getConditionThreeHoursAgo() {return conditionThreeHoursAgo;}
    public String getHumidityThreeHoursAgo() {return humidityThreeHoursAgo;}

    public String getTemperatureSixHoursAgo(){return temperatureSixHoursAgo;}
    public String getConditionSixHoursAgo(){return conditionSixHoursAgo;}
    public String getHumiditySixHoursAgo() {return humiditySixHoursAgo;}

    public String getTemperatureNineHoursAgo(){return temperatureNineHoursAgo;}
    public String getConditionNineHoursAgo(){return conditionNineHoursAgo;}
    public String getHumidityNineHoursAgo(){return humidityNineHoursAgo;}

    public String getCityName() {return cityName;}
    public List<String> getSavedCityNames() {return savedCityNames;}
    public boolean isUseCaseFailed() {return useCaseFailed;}
}
