package use_case.get_history;

import entity.CityFactory;
import entity.HistoryCity;
import entity.HistoryCityFactory;

/**
 * The GetHistory Interactor.
 */
public class GetHistoryInteractor implements GetHistoryInputBoundary{
    private final GetHistoryDataAccessInterface weatherDataAccessObject;
    private final GetHistoryOutputBoundary userPresenter;

    public GetHistoryInteractor(GetHistoryDataAccessInterface signupDataAccessInterface,
                                GetHistoryOutputBoundary signupOutputBoundary) {
        this.weatherDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
    }

    @Override
    public void execute(GetHistoryInputData getHistoryInputData) {
         final HistoryCity historyCity = weatherDataAccessObject.getWeatherHistory(getHistoryInputData.getCityName(), 3);
         final GetHistoryOutputData getHistoryOutputData = new GetHistoryOutputData((historyCity.getHistory()),
                 getHistoryInputData.getCityName(),getHistoryInputData.getSavedCityNames(),false);
        userPresenter.prepareSuccessView(getHistoryOutputData);
    }

    @Override
    public void switchToGetDetailsView() {
        userPresenter.switchToGetDetailsView();
    }
}
