package app;

import use_case.manage_sort.*;
import interface_adapter.manage_sort.SortCitiesController;
import interface_adapter.manage_sort.SortCitiesPresenter;
import interface_adapter.manage_sort.SortCitiesState;
import interface_adapter.manage_sort.SortCitiesViewModel;
import view.SortCitiesView;
import entity.CommonCity;

import java.util.ArrayList;
import java.util.List;

public class Main_Code_to_Run_Sort {
    public static void main(String[] args) {
        // 假设的城市列表
        List<CommonCity> savedCities = new ArrayList<>();
        savedCities.add(new CommonCity("Toronto", 10.0, "Cloudy", 60));
        savedCities.add(new CommonCity("Vancouver", 15.0, "Sunny", 50));
        savedCities.add(new CommonCity("Calgary", 5.0, "Rainy", 70));

        // 创建 State, Presenter 和 Interactor
        SortCitiesState state = new SortCitiesState();
        SortCitiesPresenter presenter = new SortCitiesPresenter(state);
        SortCitiesInteractor interactor = new SortCitiesInteractor(savedCities, presenter);

        // 创建 Controller 和 ViewModel
        SortCitiesController controller = new SortCitiesController(interactor);
        SortCitiesViewModel viewModel = new SortCitiesViewModel(state);

        // 创建并显示 View
        SortCitiesView view = new SortCitiesView(controller, viewModel);
        view.display();
    }
}
