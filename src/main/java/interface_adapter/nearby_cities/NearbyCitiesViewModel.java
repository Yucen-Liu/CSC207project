package interface_adapter.nearby_cities;

import interface_adapter.ViewModel;

public class NearbyCitiesViewModel extends ViewModel<NearbyCitiesState> {

    public static final String TITLE_LABEL = "Weather Information for Nearby Cities";
    public static final String CITY_NAMES_LABEL = "City NameS:";
    public static final String TEMPERATURE_LABEL = "Temperature:";
    public static final String CONDITION_LABEL = "Condition:";
    public static final String HUMIDITY_LABEL = "Humidity:";

    public NearbyCitiesViewModel() {
        super("nearby cities");
        setState(new NearbyCitiesState());
    }
}
