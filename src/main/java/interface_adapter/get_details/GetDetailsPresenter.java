package interface_adapter.get_details;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_forecast.GetForecastState;
import interface_adapter.get_forecast.GetForecastViewModel;
import interface_adapter.manage_sort.SortCitiesState;
import interface_adapter.nearby_cities.NearbyCitiesState;
import interface_adapter.nearby_cities.NearbyCitiesViewModel;
import interface_adapter.search_city.SearchCityViewModel;
import use_case.get_details.GetDetailsOutputBoundary;
import use_case.get_details.GetDetailsOutputData;

public class GetDetailsPresenter implements GetDetailsOutputBoundary {
    private final SearchCityViewModel searchCityViewModel;
    private final GetForecastViewModel getForecastViewModel;
    private final NearbyCitiesViewModel nearbyCitiesViewModel;
    private final GetDetailsViewModel getDetailsViewModel;
    private final ViewManagerModel viewManagerModel;

    public GetDetailsPresenter(SearchCityViewModel searchCityViewModel, GetForecastViewModel getForecastViewModel,
                               NearbyCitiesViewModel nearbyCitiesViewModel, GetDetailsViewModel getDetailsViewModel,
                               ViewManagerModel viewManagerModel) {
        this.searchCityViewModel = searchCityViewModel;
        this.getForecastViewModel = getForecastViewModel;
        this.nearbyCitiesViewModel = nearbyCitiesViewModel;
        this.viewManagerModel = viewManagerModel;
        this.getDetailsViewModel = getDetailsViewModel;
    }

    @Override
    public void switchToSearchCityView() {
        viewManagerModel.setState(searchCityViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToGetNearbyCitiesView(String cityName) {
        final NearbyCitiesState nearbyCitiesState = nearbyCitiesViewModel.getState();
        nearbyCitiesState.setCityName(cityName);
        nearbyCitiesViewModel.setState(nearbyCitiesState);
        nearbyCitiesViewModel.firePropertyChanged();

        viewManagerModel.setState(nearbyCitiesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToGetForecastView(String cityName) {
        final GetForecastState getForecastState = getForecastViewModel.getState();
        getForecastState.setCityName(cityName);
        getForecastViewModel.setState(getForecastState);
        getForecastViewModel.firePropertyChanged();

        viewManagerModel.setState(getForecastViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(GetDetailsOutputData response) {
        final GetDetailsState getdetailsState = getDetailsViewModel.getState();
        getdetailsState.setCityName(response.getCityName());
        getdetailsState.setSavedCityNames(response.getSavedCityNames());

        getdetailsState.setTemperature(response.getTemperature());
        getdetailsState.setHumidity(response.getHumidity());
        getdetailsState.setCondition(response.getCondition());

        getdetailsState.setPressure(response.getPressure());
        getdetailsState.setVisibility(response.getVisibility());
        getdetailsState.setTempMax(response.getTempMax());
        getdetailsState.setTempMin(response.getTempMin());

        this.getForecastViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
