package use_case.manage_sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.manage_sort.*;
import entity.CommonCity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SortCitiesInteractorTest {

    private SortCitiesDataAccessInterface dataAccessMock;
    private SortCitiesOutputBoundary outputBoundaryMock;
    private SortCitiesInteractor interactor;

    @BeforeEach
    public void setUp() {
        dataAccessMock = mock(SortCitiesDataAccessInterface.class);
        outputBoundaryMock = mock(SortCitiesOutputBoundary.class);
        interactor = new SortCitiesInteractor(dataAccessMock, outputBoundaryMock);
    }

    @Test
    public void testSortByTemperature() {
        // Arrange
        CommonCity cityA = new CommonCity("CityA", 15.0, "Sunny", 60);
        CommonCity cityB = new CommonCity("CityB", 10.0, "Cloudy", 70);
        CommonCity cityC = new CommonCity("CityC", 20.0, "Rainy", 50);

        when(dataAccessMock.getCurWeather("CityA")).thenReturn(cityA);
        when(dataAccessMock.getCurWeather("CityB")).thenReturn(cityB);
        when(dataAccessMock.getCurWeather("CityC")).thenReturn(cityC);

        SortCitiesInputData inputData = new SortCitiesInputData("temperature", Arrays.asList("CityA", "CityB", "CityC"));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(outputBoundaryMock, times(1)).presentSortedCities(argThat(outputData -> {
            List<CommonCity> sortedCities = outputData.getSortedCities();
            return sortedCities.get(0).equals(cityB) &&
                    sortedCities.get(1).equals(cityA) &&
                    sortedCities.get(2).equals(cityC);
        }));
    }

    @Test
    public void testSortByCondition() {
        // Arrange
        CommonCity cityA = new CommonCity("CityA", 15.0, "Rainy", 60);
        CommonCity cityB = new CommonCity("CityB", 10.0, "Cloudy", 70);
        CommonCity cityC = new CommonCity("CityC", 20.0, "Sunny", 50);

        when(dataAccessMock.getCurWeather("CityA")).thenReturn(cityA);
        when(dataAccessMock.getCurWeather("CityB")).thenReturn(cityB);
        when(dataAccessMock.getCurWeather("CityC")).thenReturn(cityC);

        SortCitiesInputData inputData = new SortCitiesInputData("condition", Arrays.asList("CityA", "CityB", "CityC"));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(outputBoundaryMock, times(1)).presentSortedCities(argThat(outputData -> {
            List<CommonCity> sortedCities = outputData.getSortedCities();
            return sortedCities.get(0).equals(cityB) &&
                    sortedCities.get(1).equals(cityA) &&
                    sortedCities.get(2).equals(cityC);
        }));
    }

    @Test
    public void testInvalidCriterion() {
        // Arrange
        SortCitiesInputData inputData = new SortCitiesInputData("invalid", Arrays.asList("CityA", "CityB"));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> interactor.execute(inputData));
    }
}

