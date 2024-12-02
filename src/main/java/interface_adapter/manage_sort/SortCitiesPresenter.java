package interface_adapter.manage_sort;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_city.SearchCityViewModel;
import use_case.manage_sort.SortCitiesOutputBoundary;
import use_case.manage_sort.SortCitiesOutputData;

import javax.swing.text.View;

/**
 * Presenter for the SortCities use case.
 */
public class SortCitiesPresenter implements SortCitiesOutputBoundary {
    private SearchCityViewModel searchCityViewModel;
    private SortCitiesViewModel sortCitiesViewModel;
    private ViewManagerModel viewManagerModel;



    // The only input of teh presenter is the state
    // The only method of teh presenter is the presentSortedCities which use input 'sorted city list' from Output Data
    public SortCitiesPresenter(SearchCityViewModel searchCityViewModel, SortCitiesViewModel sortCitiesViewModel,
                               ViewManagerModel viewManagerModel) {
        this.searchCityViewModel = searchCityViewModel;
        this.sortCitiesViewModel = sortCitiesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void presentSortedCities(SortCitiesOutputData outputData) {
        final SortCitiesState sortCitiesState = sortCitiesViewModel.getState();
        sortCitiesState.setSortedCities(outputData.getSortedCities());

        // 修正为传递整个状态对象
        sortCitiesViewModel.firePropertyChanged("sortedCities", null, sortCitiesState);
    }




    @Override
    public void switchToSearchCityView() {
        viewManagerModel.setState(sortCitiesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
