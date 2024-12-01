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
        if (weatherHistory == null || weatherHistory.size() < 3) {
            throw new IllegalArgumentException("Weather history must contain at least three entries.");
        }

        this.temperatureThreeHoursLater = getWeatherDetail(weatherHistory, 0, 0);
        this.conditionThreeHoursLater = getWeatherDetail(weatherHistory, 0, 1);
        this.humidityThreeHoursLater = getWeatherDetail(weatherHistory, 0, 2);

        this.temperatureSixHoursLater = getWeatherDetail(weatherHistory, 1, 0);
        this.conditionSixHoursLater = getWeatherDetail(weatherHistory, 1, 1);
        this.humiditySixHoursLater = getWeatherDetail(weatherHistory, 1, 2);

        this.temperatureNineHoursLater = getWeatherDetail(weatherHistory, 2, 0);
        this.conditionNineHoursLater = getWeatherDetail(weatherHistory, 2, 1);
        this.humidityNineHoursLater = getWeatherDetail(weatherHistory, 2, 2);

        this.cityName = cityName;
        this.savedCityNames = savedCityNames;
        this.useCaseFailed = useCaseFailed;
    }

    private String getWeatherDetail(List<List<String>> weatherHistory, int outerIndex, int innerIndex) {
        return (weatherHistory.size() > outerIndex && weatherHistory.get(outerIndex).size() > innerIndex)
                ? weatherHistory.get(outerIndex).get(innerIndex)
                : "N/A";
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
