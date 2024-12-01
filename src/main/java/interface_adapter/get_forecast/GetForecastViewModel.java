package interface_adapter.get_forecast;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the GetHistory View.
 */
public class GetForecastViewModel extends ViewModel<GetForecastState> {

    public static final String GET_FORECAST_TITLE_LABEL = "Weather Forecast for the Next 9 Hours (3-Hour Intervals)";
    public static final String CITY_NAME_LABEL = "City Name:";
    public static final String THREE_HOURS_AGO_LABEL = "3 Hours Later";
    public static final String SIX_HOURS_AGO_LABEL = "6 Hours Later";
    public static final String NINE_HOURS_AGO_LABEL = "9 Hours Later";
    public static final String TEMPERATURE_LABEL = "Temperature:";
    public static final String CONDITION_LABEL = "Condition:";
    public static final String HUMIDITY_LABEL = "Humidity:";
    public static final String GET_FORECAST_BUTTON_LABEL = "Get Forecast";
    public static final String INFO_LABEL = "Info";




    public static final String BACK_BUTTON_LABEL = "Back";

    public GetForecastViewModel() {
        super("get forecast");
        setState(new GetForecastState());
    }
    // Expose state fields through ViewModel
    public String getCityName() {
        return getState().getCityName();
    }

    public String getTemperatureThreeHoursLater() {
        return getState().getTemperatureThreeHoursLater();
    }

    public String getConditionThreeHoursLater() {
        return getState().getConditionThreeHoursLater();
    }

    public String getHumidityThreeHoursLater() {
        return getState().getHumidityThreeHoursLater();
    }
}
