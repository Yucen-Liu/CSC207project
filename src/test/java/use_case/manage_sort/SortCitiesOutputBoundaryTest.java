package use_case.manage_sort;

import org.junit.jupiter.api.Test;
import use_case.manage_sort.SortCitiesOutputBoundary;
import use_case.manage_sort.SortCitiesOutputData;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class SortCitiesOutputBoundaryTest {

    @Test
    public void testPresentSortedCities() {
        SortCitiesOutputBoundary outputBoundary = mock(SortCitiesOutputBoundary.class);

        SortCitiesOutputData outputData = mock(SortCitiesOutputData.class);
        when(outputData.getSortedCities()).thenReturn(Arrays.asList());

        outputBoundary.presentSortedCities(outputData);

        verify(outputBoundary, times(1)).presentSortedCities(outputData);
    }
}
