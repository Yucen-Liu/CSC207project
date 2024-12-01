package use_case.nearby_cities;

import entity.NearbyCity;

import java.util.ArrayList;

public class NearbyCitiesInteractor implements NearbyCitiesInputBoundary{
    private final NearbyCitiesDataAccessInterface nearbyCitiesDataAccessObject;
    private final NearbyCitiesOutputBoundary userPresenter;

    public NearbyCitiesInteractor(NearbyCitiesDataAccessInterface nearbyCitiesDataAccessObject,
                                  NearbyCitiesOutputBoundary userPresenter) {
        this.nearbyCitiesDataAccessObject = nearbyCitiesDataAccessObject;
        this.userPresenter = userPresenter;
    }

    @Override
    public void execute(NearbyCitiesInputData nearbyCitiesInputData) {
        final ArrayList<NearbyCity> nearbyCities = nearbyCitiesDataAccessObject.getNearbyCities(nearbyCitiesInputData.getCityName());
        final NearbyCitiesOutputData nearbyCitiesOutputData = new NearbyCitiesOutputData(nearbyCities,
                nearbyCitiesInputData.getCityName(), nearbyCitiesInputData.getSavedCityNames());
        userPresenter.nearbyCitiesInformationView(nearbyCitiesOutputData);
    }

    @Override
    public void switchToGetDetailsView() {
        userPresenter.switchToGetDetailsView();
    }
}
