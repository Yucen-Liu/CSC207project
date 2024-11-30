package interface_adapter.check_city;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.check_city.CheckCityOutputBoundary;

/**
 * The Presenter for the CheckCity Use Case.
 */
public class CheckCityPresenter implements CheckCityOutputBoundary {

    private final CheckCityViewModel checkCityViewModel;
    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;
    private final SignupViewModel signupViewModel;

    public CheckCityPresenter(CheckCityViewModel checkCityViewModel,
                              ViewManagerModel viewManagerModel,
                              LoginViewModel loginViewModel,
                              SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.checkCityViewModel = checkCityViewModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void citynameExist(String successfulResult){
        final CheckCityState checkCityState = checkCityViewModel.getState();
        checkCityState.setCityNameResult(successfulResult);
        this.checkCityViewModel.firePropertyChanged();
    }

    @Override
    public void citynameNonExist(String failedResult ){
        final CheckCityState checkCityState = checkCityViewModel.getState();
        checkCityState.setCityNameResult(failedResult);
        this.checkCityViewModel.firePropertyChanged();
    }

    @Override
    public void switchToLoginView() {
        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToSignupView() {
        viewManagerModel.setState(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

