package interface_adapter.get_history;

import interface_adapter.ViewModel;
import interface_adapter.check_city.CheckCityState;

/**
 * The ViewModel for the GetHistory View.
 */
public class GetHistoryViewModel extends ViewModel<GetHistoryState> {

    public static final String GET_HISTORY_TITLE_LABEL = "Weather History for the Past 9 Hours (3-Hour Intervals)";
    public static final String CITY_NAME_LABEL = "City Name:";
    public static final String THREE_HOURS_AGO_LABEL = "3 Hours Ago";
    public static final String SIX_HOURS_AGO_LABEL = "6 Hours Ago";
    public static final String NINE_HOURS_AGO_LABEL = "9 Hours Ago";

    public static final String BACK_BUTTON_LABEL = "Back";

    public GetHistoryViewModel() {
        super("get history");
        setState(new GetHistoryState());
    }
}
