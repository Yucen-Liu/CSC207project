package interface_adapter.check_city;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the CheckCity View.
 */
public class CheckCityViewModel extends ViewModel<CheckCityState> {

    public static final String APPLICATION_TITLE_LABEL = "Weather Information";
    public static final String CHECK_CITY_LABEL = "See if we have the city you are interested in:";

    public static final String SAVE_BUTTON_LABEL = "Save";
    public static final String CHECK_CITY_BUTTON_LABEL = "Check";

    public CheckCityViewModel() {
        super("check city");
        setState(new CheckCityState());
    }


}
