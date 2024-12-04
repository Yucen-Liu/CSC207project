package use_case.manage_sort;

import entity.CommonCity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Test for interactor
class SortCitiesInteractorTest {

    @Mock
    private SortCitiesOutputBoundary mockOutputBoundary;

    @Mock
    private SortCitiesDataAccessInterface mockDataAccessInterface;

    private SortCitiesInteractor sortCitiesInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sortCitiesInteractor = new SortCitiesInteractor(mockDataAccessInterface, mockOutputBoundary);
    }
    // Test for temperature
    @Test
    void testExecuteSortByTemperature() {
        List<String> savedCityNames = List.of("Tokyo", "Osaka", "Nagoya");
        List<CommonCity> commonCities = new ArrayList<>();
        commonCities.add(new CommonCity("Tokyo", 100, "Sunny", 60));
        commonCities.add(new CommonCity("Osaka", 120, "Cloudy", 70));
        commonCities.add(new CommonCity("Nagoya", 110, "Rainy", 80));

        when(mockDataAccessInterface.getCurWeather("Tokyo")).thenReturn(commonCities.get(0));
        when(mockDataAccessInterface.getCurWeather("Osaka")).thenReturn(commonCities.get(1));
        when(mockDataAccessInterface.getCurWeather("Nagoya")).thenReturn(commonCities.get(2));

        SortCitiesInputData inputData = new SortCitiesInputData("temperature", savedCityNames);
        sortCitiesInteractor.execute(inputData);


        verify(mockOutputBoundary, atLeastOnce()).presentSortedCities(any(SortCitiesOutputData.class));
    }

    // Test for condition
    @Test
    void testExecuteSortByCondition() {
        List<String> savedCityNames = List.of("Tokyo", "Osaka", "Nagoya");
        List<CommonCity> commonCities = new ArrayList<>();
        commonCities.add(new CommonCity("Tokyo", 100, "Sunny", 60));
        commonCities.add(new CommonCity("Osaka", 120, "Cloudy", 70));
        commonCities.add(new CommonCity("Nagoya", 110, "Rainy", 80));

        when(mockDataAccessInterface.getCurWeather("Tokyo")).thenReturn(commonCities.get(0));
        when(mockDataAccessInterface.getCurWeather("Osaka")).thenReturn(commonCities.get(1));
        when(mockDataAccessInterface.getCurWeather("Nagoya")).thenReturn(commonCities.get(2));

        SortCitiesInputData inputData = new SortCitiesInputData("condition", savedCityNames);
        sortCitiesInteractor.execute(inputData);


        verify(mockOutputBoundary, atLeastOnce()).presentSortedCities(any(SortCitiesOutputData.class));
    }

    // Test for nothing input
    @Test
    void testExecuteWithEmptyCityList() {

        SortCitiesInputData inputData = new SortCitiesInputData("temperature", new ArrayList<>());

        sortCitiesInteractor.execute(inputData);

        verify(mockOutputBoundary, times(2)).presentSortedCities(argThat(outputData ->
                outputData.getSortedCities().isEmpty()
        ));
    }

    // Test for invaild Criterion
    @Test
    void testExecuteWithInvalidCriterion() {
        SortCitiesInputData inputData = new SortCitiesInputData("invalidCriterion", List.of("Tokyo", "Osaka"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sortCitiesInteractor.execute(inputData);
        });
        assertEquals("Invalid sort criterion: invalidCriterion", exception.getMessage());
    }
}
