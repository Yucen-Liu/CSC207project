package interface_adapter.nearby_cities;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_details.GetDetailsViewModel;
import use_case.nearby_cities.NearbyCitiesOutputBoundary;
import use_case.nearby_cities.NearbyCitiesOutputData;
import view.ViewManager;

public class NearbyCitiesPresenter implements NearbyCitiesOutputBoundary {
    private final NearbyCitiesViewModel nearbyCitiesViewModel;
    private final ViewManagerModel viewManagerModel;
    private final GetDetailsViewModel getDetailsViewModel;

    public NearbyCitiesPresenter(NearbyCitiesViewModel nearbyCitiesViewModel, ViewManagerModel viewManagerModel,
                                 GetDetailsViewModel getDetailsViewModel) {
        this.nearbyCitiesViewModel = nearbyCitiesViewModel;
        this.viewManagerModel = viewManagerModel;
        this.getDetailsViewModel = getDetailsViewModel;
    }

    @Override
    public void switchToGetDetailsView() {
        viewManagerModel.setState(getDetailsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void nearbyCitiesInformationView(NearbyCitiesOutputData nearbyCitiesOutputData) {
        final NearbyCitiesState nearbyCitiesState = nearbyCitiesViewModel.getState();
        nearbyCitiesState.setNearbyCityTemperatures(nearbyCitiesOutputData.getNearbyCitiesTemperature());
        nearbyCitiesState.setNearbyCityConditions(nearbyCitiesOutputData.getNearbyCitiesCondition());
        nearbyCitiesState.setNearbyCityHumidities(nearbyCitiesOutputData.getNearbyCitiesHumidity());
        this.nearbyCitiesViewModel.firePropertyChanged();
    }
}
