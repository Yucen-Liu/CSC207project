package interface_adapter.search_city;

import interface_adapter.ViewModel;

import java.util.List;

/**
 * The ViewModel for the CheckCity View.
 */
public class SearchCityViewModel extends ViewModel<SearchCityState> {
    public SearchCityViewModel() {
        super("search city");
        setState(new SearchCityState());
    }

    public String getLocation() { return getState().getLocation(); }
    public Double getTemperature() { return getState().getTemperature(); }
    public String getCondition() { return getState().getCondition(); }
    public int getHumidity() { return getState().getHumidity(); }
    public List<String> getSavedCityNames() { return getState().getSavedCityNames(); }
}
