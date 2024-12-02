package interface_adapter.search_city;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_details.GetDetailsViewModel;
import interface_adapter.get_forecast.GetForecastViewModel;
import interface_adapter.manage_cities.ManageCitiesViewModel;
import interface_adapter.manage_sort.SortCitiesViewModel;
import interface_adapter.nearby_cities.NearbyCitiesViewModel;
import use_case.search_city.SearchCityOutputBoundary;
import use_case.search_city.SearchCityOutputData;

public class SearchCityPresenter implements SearchCityOutputBoundary {
    private final SearchCityViewModel searchCityViewModel;
    private final GetDetailsViewModel getDetailsViewModel;
    private final SortCitiesViewModel sortCitiesViewModel;
    private final ViewManagerModel viewManagerModel;

    public SearchCityPresenter(SearchCityViewModel searchCityViewModel, GetDetailsViewModel getDetailsViewModel,
                               SortCitiesViewModel sortCitiesViewModel, ViewManagerModel viewManagerModel) {
        this.searchCityViewModel = searchCityViewModel;
        this.getDetailsViewModel = getDetailsViewModel;
        this.sortCitiesViewModel = sortCitiesViewModel;
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
    public void switchToGetDetailsView() {
        viewManagerModel.setState(getDetailsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToSortCitiesView() {
        viewManagerModel.setState(sortCitiesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
