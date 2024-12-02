package interface_adapter.manage_sort;

import use_case.manage_sort.SortCitiesOutputBoundary;
import use_case.manage_sort.SortCitiesOutputData;

/**
 * Presenter for the SortCities use case.
 */
public class SortCitiesPresenter implements SortCitiesOutputBoundary {

    private final SortCitiesState state;


    // The only input of teh presenter is the state
    // The only method of teh presenter is the presentSortedCities which use input 'sorted city list' from Output Data
    public SortCitiesPresenter(SortCitiesState state) {
        this.state = state;
    }

    @Override
    public void presentSortedCities(SortCitiesOutputData outputData) {
        // 将排序后的城市列表存储到状态中
        state.setSortedCities(outputData.getSortedCities());
    }
}
