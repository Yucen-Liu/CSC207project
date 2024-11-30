package use_case.check_city;


/**
 * The CheckCity Interactor.
 */
public class CheckCityInteractor implements CheckCityInputBoundary{

    private final CheckCityDataAccessInterface userDataAccessObject;
    private final CheckCityOutputBoundary userPresenter;

    public CheckCityInteractor(CheckCityDataAccessInterface checkcitydataAccessInterface,
                               CheckCityOutputBoundary checkCityOutputBoundary) {
        this.userDataAccessObject= checkcitydataAccessInterface;
        this.userPresenter = checkCityOutputBoundary;
    }

    @Override
    public void execute(CheckCityInputData checkCityInputData) {
        if(userDataAccessObject.existsByName(checkCityInputData.getCityname())){
            userPresenter.citynameExist("It's in our application! You can save it and view more detailed weather info!");
        }
        else{
            userPresenter.citynameNonExist("Sorry, no weather info for this city now...");
        }
    }

    @Override
    public void switchToLoginView() {
        userPresenter.switchToLoginView();
    }

    @Override
    public void switchToSignupView() {
        userPresenter.switchToSignupView();
    }
}
