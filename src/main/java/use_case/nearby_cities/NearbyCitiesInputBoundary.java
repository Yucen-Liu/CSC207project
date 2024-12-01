package use_case.nearby_cities;

public interface NearbyCitiesInputBoundary{
    void execute(NearbyCitiesInputData nearbyCitiesInputData);
    void switchToGetDetailsView();
}
