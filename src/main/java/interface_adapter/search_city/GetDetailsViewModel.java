package interface_adapter.search_city;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the CheckCity View.
 */
public class GetDetailsViewModel extends ViewModel<SearchCityState> {
    public GetDetailsViewModel() {
        super("search city");
        setState(new SearchCityState());
    }
}
