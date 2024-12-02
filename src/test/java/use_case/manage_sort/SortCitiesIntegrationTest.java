package use_case.manage_sort;

import entity.CommonCity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.manage_sort.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortCitiesIntegrationTest {

    private List<CommonCity> savedCities;
    private SortCitiesInteractor interactor;

    @BeforeEach
    public void setUp() {
        savedCities = new ArrayList<>(Arrays.asList(
                new CommonCity("CityA", 25.5, "Sunny", 40),
                new CommonCity("CityB", 30.0, "Rainy", 60),
                new CommonCity("CityC", 20.0, "Cloudy", 50)
        ));
        SortCitiesOutputBoundary outputBoundary = new SortCitiesOutputBoundary() {
            @Override
            public void presentSortedCities(SortCitiesOutputData outputData) {
                List<CommonCity> sortedCities = outputData.getSortedCities();
                savedCities.clear();
                savedCities.addAll(sortedCities);
            }
        };
        interactor = new SortCitiesInteractor(savedCities, outputBoundary);
    }

    @Test
    public void testSortByTemperatureIntegration() {
        SortCitiesInputData inputData = new SortCitiesInputData("temperature");
        interactor.sort(inputData);

        assertEquals("CityC", savedCities.get(0).getLocation());
        assertEquals("CityA", savedCities.get(1).getLocation());
        assertEquals("CityB", savedCities.get(2).getLocation());
    }
}
