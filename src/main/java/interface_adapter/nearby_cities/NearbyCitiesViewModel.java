package interface_adapter.nearby_cities;

import interface_adapter.ViewModel;

import java.util.List;

public class NearbyCitiesViewModel extends ViewModel<NearbyCitiesState> {

    public static final String TITLE_LABEL = "Weather Information for Nearby Cities";
    public static final String CITY_NAMES_LABEL = "City Names:";
    public static final String TEMPERATURE_LABEL = "Temperature:";
    public static final String CONDITION_LABEL = "Condition:";
    public static final String HUMIDITY_LABEL = "Humidity:";

    public static final String BACK_BUTTON_LABEL = "Back";

    public NearbyCitiesViewModel() {
        super("nearby cities");
        setState(new NearbyCitiesState());
    }

    public List<String> getNearbyCityNames(){
        return getState().getNearbyCityNames();
    }

    public List<Double> getNearbyCitiesTemperature(){
        return getState().getNearbyCityTemperatures();
    }

    public List<String> getNearbyCitiesCondition(){
        return getState().getNearbyCityConditions();
    }

    public List<Integer> getNearbyCitiesHumidity(){
        return getState().getNearbyCityHumidities();
    }
}
