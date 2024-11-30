package interface_adapter.get_history;

import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.check_city.CheckCityState;
import interface_adapter.login.LoginState;
import interface_adapter.search_city.SearchCityViewModel;
import use_case.get_history.GetHistoryOutputBoundary;
import use_case.get_history.GetHistoryOutputData;
import use_case.logout.LogoutOutputData;

/**
 * The Presenter for the GetHistory Use Case.
 */
public class GetHistoryPresenter {
    private final GetHistoryViewModel getHistoryViewModel;
    private final ViewManagerModel viewManagerModel;
    private final SearchCityViewModel searchCityViewModel;

    public GetHistoryPresenter(GetHistoryViewModel getHistoryViewModel,
                               ViewManagerModel viewManagerModel,
                               SearchCityViewModel searchCityViewModel) {
        this.getHistoryViewModel = getHistoryViewModel;
        this.viewManagerModel = viewManagerModel;
        this.searchCityViewModel = searchCityViewModel;
    }
//
//    @Override
//    public void switchToSearchCityView() {
//        viewManagerModel.setState(searchCityViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//    }

    public void prepareSuccessView(GetHistoryOutputData response) {
    }
}
