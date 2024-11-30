package interface_adapter.search_city;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the CheckCity View.
 */
public class SearchCityViewModel extends ViewModel<SearchCityState> {
    public SearchCityViewModel() {
        super("search city");
        setState(new SearchCityState());
    }
}
