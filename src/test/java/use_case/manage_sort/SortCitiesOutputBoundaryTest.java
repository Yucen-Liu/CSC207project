package use_case.manage_sort;

import org.junit.jupiter.api.Test;
import use_case.manage_sort.*;
import entity.CommonCity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class SortCitiesOutputBoundaryTest {

    @Test
    public void testPresentSortedCities() {
        // Arrange
        SortCitiesOutputBoundary outputBoundaryMock = mock(SortCitiesOutputBoundary.class);
        List<CommonCity> sortedCities = Arrays.asList(
                new CommonCity("CityA", 10.0, "Sunny", 50),
                new CommonCity("CityB", 15.0, "Cloudy", 60)
        );
        SortCitiesOutputData outputData = new SortCitiesOutputData(sortedCities);

        // Act
        outputBoundaryMock.presentSortedCities(outputData);

        // Assert
        verify(outputBoundaryMock, times(1)).presentSortedCities(outputData);
    }
}

