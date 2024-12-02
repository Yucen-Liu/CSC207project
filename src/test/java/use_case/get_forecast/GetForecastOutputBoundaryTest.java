package use_case.get_forecast;

import org.junit.jupiter.api.Test;
import use_case.get_forecast.*;

import java.util.List;

import static org.mockito.Mockito.*;

public class GetForecastOutputBoundaryTest {

    @Test
    public void testPrepareSuccessView() {
        // Arrange
        GetForecastOutputBoundary outputBoundaryMock = mock(GetForecastOutputBoundary.class);

        GetForecastOutputData outputData = new GetForecastOutputData(
                List.of(
                        List.of("25°C", "Sunny", "60%"),
                        List.of("20°C", "Rainy", "70%"),
                        List.of("22°C", "Cloudy", "65%")
                ),
                "CityA",
                List.of("CityB", "CityC"),
                false
        );

        // Act
        outputBoundaryMock.prepareSuccessView(outputData);

        // Assert
        verify(outputBoundaryMock, times(1)).prepareSuccessView(outputData);
    }

    @Test
    public void testPrepareFailView() {
        // Arrange
        GetForecastOutputBoundary outputBoundaryMock = mock(GetForecastOutputBoundary.class);

        // Act
        outputBoundaryMock.prepareFailView("Data fetch error.");

        // Assert
        verify(outputBoundaryMock, times(1)).prepareFailView("Data fetch error.");
    }
}

