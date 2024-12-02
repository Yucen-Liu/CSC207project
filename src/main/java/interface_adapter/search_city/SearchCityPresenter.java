package interface_adapter.search_city;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_forecast.GetForecastViewModel;
import interface_adapter.nearby_cities.NearbyCitiesViewModel;
import use_case.search_city.SearchCityOutputBoundary;
import use_case.search_city.SearchCityOutputData;

public class SearchCityPresenter implements SearchCityOutputBoundary {
    private final SearchCityViewModel searchCityViewModel;
    private final GetForecastViewModel getForecastViewModel;
    private final NearbyCitiesViewModel nearbyCitiesViewModel;
    private final ViewManagerModel viewManagerModel;

    public SearchCityPresenter(SearchCityViewModel searchCityViewModel, GetForecastViewModel getForecastViewModel,
                               NearbyCitiesViewModel nearbyCitiesViewModel, ViewManagerModel viewManagerModel) {
        this.searchCityViewModel = searchCityViewModel;
        this.getForecastViewModel = getForecastViewModel;
        this.nearbyCitiesViewModel = nearbyCitiesViewModel;
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

    @Override
    public void switchToGetForecastView() {
        viewManagerModel.setState(getForecastViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void switchToGetNearbyCitiesView() {
        viewManagerModel.setState(nearbyCitiesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
