package use_case.get_history;

import entity.City;
import entity.CityFactory;
import entity.HistoryCity;
import entity.HistoryCityFactory;
import use_case.signup.SignupOutputData;

/**
 * The GetHistory Interactor.
 */
public class GetHistoryInteractor implements GetHistoryInputBoundary{
    private final GetHistoryDataAccessInterface weatherDataAccessObject;
    private final GetHistoryOutputBoundary userPresenter;
    private final CityFactory cityFactory = new HistoryCityFactory();

    public GetHistoryInteractor(GetHistoryDataAccessInterface signupDataAccessInterface,
                                GetHistoryOutputBoundary signupOutputBoundary) {
        this.weatherDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
    }

    @Override
    public void execute(GetHistoryInputData getHistoryInputData) {
         final HistoryCity historyCity = weatherDataAccessObject.getWeatherHistory(getHistoryInputData.getCityName(), 3);
         final GetHistoryOutputData getHistoryOutputData = new GetHistoryOutputData((historyCity.getHistory()));
    }

    @Override
    public void switchToSearchCityView() {
        userPresenter.switchToSearchCityView();
    }
}
