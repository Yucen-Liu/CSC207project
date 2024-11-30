package use_case.get_history;

import entity.CityFactory;
import use_case.signup.SignupInputData;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;
import use_case.signup.SignupUserDataAccessInterface;

/**
 * The GetHistory Interactor.
 */
//public class GetHistoryInteractor implements GetHistoryInputBoundary{
//    private final GetHistoryDataAccessInterface weatherDataAccessObject;
//    private final GetHistoryOutputBoundary userPresenter;
//    private final CityFactory cityFactory;
//
//    public GetHistoryInteractor(GetHistoryDataAccessInterface signupDataAccessInterface,
//                                GetHistoryOutputBoundary signupOutputBoundary,
//                            CityFactory cityFactory) {
//        this.weatherDataAccessObject = signupDataAccessInterface;
//        this.userPresenter = signupOutputBoundary;
//        this.cityFactory = cityFactory;
//    }

//    @Override
//    public void execute(GetHistoryInputData getHistoryInputData) {
//        if (userDataAccessObject.existsByName(siggnupnupInputData.getUsername())) {
//            userPresenter.prepareFailView("User already exists.");
//        }
//        else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
//            userPresenter.prepareFailView("Passwords don't match.");
//        }
//        else {
//            final User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword());
//            userDataAccessObject.save(user);
//
//            final SignupOutputData signupOutputData = new SignupOutputData(user.getName(), false);
//            userPresenter.prepareSuccessView(signupOutputData);
//        }
//    }
//
//    @Override
//    public void switchToSearchCityView() {
//        userPresenter.switchSearchCityiew();
//    }
//}
