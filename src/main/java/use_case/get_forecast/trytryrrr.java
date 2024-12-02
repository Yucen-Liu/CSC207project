package use_case.manage_sort;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;


import entity.CommonCity;

/**
 * Interactor for the SortCities use case.
 */
public class SortCitiesInteractor implements SortCitiesInputBoundary {

    // Initialize Part 1 We need to create an outputBoundary
    private final SortCitiesOutputBoundary outputBoundary;
    // Initialize Part 2: dataAccess in order to get weather through City name
    private final SortCitiesDataAccessInterface dataAccess;

    // 生成一个 'Interactor'需要input：1. list of CommonCity (saved list) 2. outputBoundary

    public SortCitiesInteractor(SortCitiesDataAccessInterface dataAccess, SortCitiesOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    // Override the sort method from input boundary
    // The only input is InputData class, and we don't care what data is that, we just assume there's correct data input






    @Override
    public void execute(SortCitiesInputData inputData) {

        String criterion = inputData.getCriterion();
        List<CommonCity> savedCities = new ArrayList<>();

        for (String name: inputData.getSavedCityNames()){
            CommonCity city = (CommonCity) dataAccess.getCurWeather(name);
            savedCities.add(city);}

        switch (criterion.toLowerCase()) {
            case "temperature":
                Collections.sort(savedCities, Comparator.comparingDouble(CommonCity::getTemperature));
                break;
            case "condition":
                Collections.sort(savedCities, Comparator.comparing(CommonCity::getCondition));
                break;
            case "humidity":
                Collections.sort(savedCities, Comparator.comparingInt(CommonCity::getHumidity));
                break;
            default:
                throw new IllegalArgumentException("Invalid sort criterion: " + criterion);
        }

        // Create output data and pass it to the output boundary
        // Here 我们的 savedCities 是 sort好了，生成一个新的Output Data class 并扔给他 sorted list,
        SortCitiesOutputData outputData = new SortCitiesOutputData(savedCities);

        // 再把这个data存到 'OutputBoundary' which is used by 'Presenter'
        outputBoundary.presentSortedCities(outputData);
    }


    @Override
    public void switchToSearchCityView() {outputBoundary.switchToSearchCityView();}

}



public SortCitiesInteractor(SortCitiesDataAccessInterface dataAccess, SortCitiesOutputBoundary outputBoundary) {
    this.dataAccess = dataAccess;
    this.outputBoundary = outputBoundary;
}
