package use_case.get_forecast;

import java.util.List;

/**
 * Output Data for the GetHistory Use Case.
 */
public class GetForecastOutputData {

    private final String cityName;
    private final List<String> savedCityNames;

    private final String temperatureThreeHoursLater;
    private final String conditionThreeHoursLater;
    private final String humidityThreeHoursLater;

    private final String temperatureSixHoursLater;
    private final String conditionSixHoursLater;
    private final String humiditySixHoursLater;

    private final String temperatureNineHoursLater;
    private final String conditionNineHoursLater;
    private final String humidityNineHoursLater;

    private final boolean useCaseFailed;

    public GetForecastOutputData(List<List<String>> weatherHistory, String cityName, List<String> savedCityNames, boolean useCaseFailed) {
        this.temperatureThreeHoursLater = weatherHistory.get(0).get(0);
        this.conditionThreeHoursLater = weatherHistory.get(0).get(1);
        this.humidityThreeHoursLater = weatherHistory.get(0).get(2);

        this.temperatureSixHoursLater = weatherHistory.get(1).get(0);
        this.conditionSixHoursLater = weatherHistory.get(1).get(1);
        this.humiditySixHoursLater = weatherHistory.get(1).get(2);

        this.temperatureNineHoursLater = weatherHistory.get(2).get(0);
        this.conditionNineHoursLater = weatherHistory.get(2).get(1);
        this.humidityNineHoursLater = weatherHistory.get(2).get(2);

        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTemperatureThreeHoursLater() {return temperatureThreeHoursLater;}
    public String getConditionThreeHoursLater() {return conditionThreeHoursLater;}
    public String getHumidityThreeHoursLater() {return humidityThreeHoursLater;}

    public String getTemperatureSixHoursLater(){return temperatureSixHoursLater;}
    public String getConditionSixHoursLater(){return conditionSixHoursLater;}
    public String getHumiditySixHoursLater() {return humiditySixHoursLater;}

    public String getTemperatureNineHoursLater(){return temperatureNineHoursLater;}
    public String getConditionNineHoursLater(){return conditionNineHoursLater;}
    public String getHumidityNineHoursLater(){return humidityNineHoursLater;}

    public String getCityName() {return cityName;}
    public List<String> getSavedCityNames() {return savedCityNames;}
    public boolean isUseCaseFailed() {return useCaseFailed;}
}
