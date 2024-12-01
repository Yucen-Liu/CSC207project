package use_case.manage_sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Interactor for the sort cities use case.
 */
public class SortCitiesInteractor implements SortCitiesInputBoundary {
    private final List<String> cities; // List of saved cities
    private final SortCitiesOutputBoundary outputBoundary;

    public SortCitiesInteractor(List<String> cities, SortCitiesOutputBoundary outputBoundary) {
        this.cities = cities;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void sortCities(String sortBy) {
        // Sort logic based on the sortBy criteria
        Comparator<String> comparator;
        switch (sortBy.toLowerCase()) {
            case "temperature":
                comparator = Comparator.comparing(city -> getTemperature(city));
                break;
            case "condition":
                comparator = Comparator.comparing(city -> getCondition(city));
                break;
            case "humidity":
                comparator = Comparator.comparing(city -> getHumidity(city));
                break;
            default:
                throw new IllegalArgumentException("Invalid sort criteria: " + sortBy);
        }
        Collections.sort(cities, comparator);
        outputBoundary.presentSortedCities(cities);
    }

    // Placeholder methods for fetching data
    private int getTemperature(String city) {
        // Dummy implementation
        return 0;
    }

    private String getCondition(String city) {
        // Dummy implementation
        return "";
    }

    private int getHumidity(String city) {
        // Dummy implementation
        return 0;
    }
}
