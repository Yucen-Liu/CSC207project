package use_case.manage_sort;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;


import entity.CommonCity;

/**
 * Interactor for the SortCities use case.
 */
public class SortCitiesInteractor implements SortCitiesInputBoundary {

    // Initialize Part 1 We need to create an outputBoundary
    private final SortCitiesOutputBoundary outputBoundary;
    // Initialize Part 2: dataAccessInterface in order to get weather through City name
    private final SortCitiesDataAccessInterface dataAccessInterface;



    // 生成一个 'Interactor'需要input：1. list of CommonCity (saved list) 2. outputBoundary
    public SortCitiesInteractor(SortCitiesDataAccessInterface dataAccessInterface, SortCitiesOutputBoundary outputBoundary){
        this.dataAccessInterface = dataAccessInterface;
        this.outputBoundary = outputBoundary;
    }



    // Override the sort method from input boundary
    // The only input is InputData class, and we don't care what data is that, we just assume there's correct data input
    @Override
    public void switchToSearchCityView(){
    outputBoundary.switchToSearchCityView();}



    @Override
    public void execute(SortCitiesInputData inputData){

        String theCriterion = inputData.getCriterion();

        List<CommonCity> newSavedCities = new ArrayList<>();
        // Use the while loop to reach all Common City in teh list
        List<String> cityNames = inputData.getSavedCityNames();

        int index = 0;
        while (index < cityNames.size()){
            String name = cityNames.get(index);
            CommonCity city = (CommonCity) dataAccessInterface.getCurWeather(name);

            //Test
            System.out.println("Interactor: Weather data for city " + name + " = " + city);

            //Test


            newSavedCities.add(city);
            index++;
        }
        switch (theCriterion.toLowerCase()) {
            case "temperature":
                Collections.sort(newSavedCities, Comparator.comparingDouble(CommonCity::getTemperature));
                break;
            case "condition":
                Collections.sort(newSavedCities, Comparator.comparing(CommonCity::getCondition));
                break;
            case "humidity":
                Collections.sort(newSavedCities, Comparator.comparingInt(CommonCity::getHumidity));
                break;
            default:
                throw new IllegalArgumentException("Invalid sort criterion: " + theCriterion);
        }
        // 调试信息
        System.out.println("Interactor: Sorted cities: " + newSavedCities);

        SortCitiesOutputData outputData1 = new SortCitiesOutputData(newSavedCities);
        outputBoundary.presentSortedCities(outputData1);



        // Create output data and pass it to the output boundary
        // Here 我们的 savedCities 是 sort好了，生成一个新的Output Data class 并扔给他 sorted list,
        SortCitiesOutputData outputData = new SortCitiesOutputData(newSavedCities);
        // 再把这个data存到 'OutputBoundary' which is used by 'Presenter'
        outputBoundary.presentSortedCities(outputData);

        System.out.println("Interactor: Input city names = " + inputData.getSavedCityNames());

    }

}