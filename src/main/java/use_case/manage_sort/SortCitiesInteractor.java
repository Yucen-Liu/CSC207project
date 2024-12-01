package use_case.manage_sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.CommonCity;

/**
 * Interactor for the SortCities use case.
 */
public class SortCitiesInteractor implements SortCitiesInputBoundary {

    private final List<CommonCity> savedCities;
    private final SortCitiesOutputBoundary outputBoundary;

    public SortCitiesInteractor(List<CommonCity> savedCities, SortCitiesOutputBoundary outputBoundary) {
        this.savedCities = savedCities;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void sort(SortCitiesInputData inputData) {
        String criterion = inputData.getCriterion();
        switch (criterion.toLowerCase()) {
            case "temperature":
                Collections.sort(savedCities, Comparator.comparingDouble(CommonCity::getTemperature));
                break;
            case "condition":
                Collections.sort(savedCities, Comparator.comparing(CommonCity::getCondition));
                break;
            case "humidity":
                Collections.sort(savedCities, Comparator.comparingDouble(CommonCity::getHumidity));
                break;
            default:
                throw new IllegalArgumentException("Invalid sort criterion: " + criterion);
        }

        // Create output data and pass it to the output boundary
        SortCitiesOutputData outputData = new SortCitiesOutputData(savedCities);
        outputBoundary.presentSortedCities(outputData);
    }
}
