package use_case.nearby_cities;

public interface NearbyCitiesOutputBoundary {
    void switchToGetDetailsView();
    void nearbyCitiesInformationView(NearbyCitiesOutputData nearbyCitiesOutputData);
}
