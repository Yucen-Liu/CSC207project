package interface_adapter.manage_sort;

import interface_adapter.get_forecast.GetForecastViewModel;
import use_case.manage_sort.SortCitiesInputBoundary;
import use_case.manage_sort.SortCitiesInputData;

import java.util.List;

/**
 * Controller for the SortCities use case.
 */
public class SortCitiesController {

    private final SortCitiesInputBoundary inputBoundary;
    private final SortCitiesViewModel viewModel;


    public SortCitiesController(SortCitiesInputBoundary inputBoundary, SortCitiesViewModel viewModel) {
        this.inputBoundary = inputBoundary;
        this.viewModel = viewModel;
    }

    /**
     * Handles the sort request by passing input data to the interactor.
     *
     * @param criterion The criterion to sort by (e.g., temperature, condition, humidity).
     */
    public void execute(String criterion, List<String> cityNames) {
        SortCitiesInputData inputData = new SortCitiesInputData(criterion,cityNames); // 从用户界面(View)中，比如用户点击了 Temperature as criterion，就生成一个新的inputdata并给他criterion
        inputBoundary.execute(inputData);
    }
    public void switchToSearchCityView() {
        inputBoundary.switchToSearchCityView();
    }

    public SortCitiesViewModel getViewModel() {
        return viewModel;
    }
}
