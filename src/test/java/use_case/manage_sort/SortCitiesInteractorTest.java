package use_case.manage_sort;

import entity.CommonCity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SortCitiesInteractorTest {

    private List<CommonCity> savedCities;
    private SortCitiesOutputBoundary outputBoundary;
    private SortCitiesInteractor interactor;

    @BeforeEach
    public void setUp() {
        savedCities = new ArrayList<>(Arrays.asList(
                new CommonCity("CityA", 25.5, "Sunny", 40),
                new CommonCity("CityB", 30.0, "Rainy", 60),
                new CommonCity("CityC", 20.0, "Cloudy", 50)
        ));
        outputBoundary = Mockito.mock(SortCitiesOutputBoundary.class);
        interactor = new SortCitiesInteractor(savedCities, outputBoundary);
    }

    @Test
    public void testSortByTemperature() {
        SortCitiesInputData inputData = new SortCitiesInputData("temperature");
        interactor.sort(inputData);

        assertEquals("CityC", savedCities.get(0).getLocation());
        assertEquals("CityA", savedCities.get(1).getLocation());
        assertEquals("CityB", savedCities.get(2).getLocation());

        verify(outputBoundary, times(1)).presentSortedCities(any(SortCitiesOutputData.class));
    }

    @Test
    public void testSortByCondition() {
        SortCitiesInputData inputData = new SortCitiesInputData("condition");
        interactor.sort(inputData);

        assertEquals("CityC", savedCities.get(0).getLocation());
        assertEquals("CityB", savedCities.get(1).getLocation());
        assertEquals("CityA", savedCities.get(2).getLocation());

        verify(outputBoundary, times(1)).presentSortedCities(any(SortCitiesOutputData.class));
    }

    @Test
    public void testSortByHumidity() {
        SortCitiesInputData inputData = new SortCitiesInputData("humidity");
        interactor.sort(inputData);

        assertEquals("CityA", savedCities.get(0).getLocation());
        assertEquals("CityC", savedCities.get(1).getLocation());
        assertEquals("CityB", savedCities.get(2).getLocation());

        verify(outputBoundary, times(1)).presentSortedCities(any(SortCitiesOutputData.class));
    }

    @Test
    public void testInvalidSortCriterion() {
        SortCitiesInputData inputData = new SortCitiesInputData("invalid");

        IllegalArgumentException exception =
                org.junit.jupiter.api.Assertions.assertThrows(
                        IllegalArgumentException.class, () -> interactor.sort(inputData)
                );

        assertEquals("Invalid sort criterion: invalid", exception.getMessage());
        verify(outputBoundary, never()).presentSortedCities(any(SortCitiesOutputData.class));
    }
}
