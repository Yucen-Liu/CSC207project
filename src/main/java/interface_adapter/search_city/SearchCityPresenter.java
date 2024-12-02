package interface_adapter.search_city;

import interface_adapter.ViewManagerModel;
import use_case.search_city.SearchCityOutputBoundary;
import use_case.search_city.SearchCityOutputData;

public class SearchCityPresenter implements SearchCityOutputBoundary {
    private final SearchCityViewModel searchCityViewModel;
    private final ViewManagerModel viewManagerModel;

    public SearchCityPresenter(SearchCityViewModel searchCityViewModel, ViewManagerModel viewManagerModel) {
        this.searchCityViewModel = searchCityViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void searchCityInformationView(SearchCityOutputData searchCityOutputData) {
        final SearchCityState searchCityState = searchCityViewModel.getState();
        searchCityState.setLocation(searchCityOutputData.getCityName());
        searchCityState.setTemperature(searchCityOutputData.getTemperature());
        searchCityState.setCondition(searchCityOutputData.getCondition());
        searchCityState.setHumidity(searchCityOutputData.getHumidity());
        searchCityViewModel.firePropertyChanged();
    }
}
