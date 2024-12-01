package use_case.search_city;

/**
 * The SearchCity Interactor.
 */
public class SearchCityInteractor implements SearchCityInputBoundary {

    private final SearchCityDataAccessInterface searchCityDataAccessObject;
    private final SearchCityOutputBoundary userPresenter;

    public SearchCityInteractor(SearchCityDataAccessInterface searchCityDataAccessInterface,
                                SearchCityOutputBoundary searchCityOutputBoundary) {
        this.searchCityDataAccessObject= searchCityDataAccessInterface;
        this.userPresenter = searchCityOutputBoundary;
    }

    @Override
    public void execute(SearchCityInputData searchcityInputData) {
//        if(userDataAccessObject.existsByName(SearchCityInputData.getCityname())){
//            userPresenter.citynameExist("It is in our application! Please signup or login.");
//        }
//        else{
//            userPresenter.citynameNonExist("Sorry... We currently offer the weather information " +
//                    "for the city you are interested in. Maybe try later?");
//        }
    }
}

