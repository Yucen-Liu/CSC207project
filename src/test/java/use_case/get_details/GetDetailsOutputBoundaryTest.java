package use_case.get_details;

import org.junit.jupiter.api.Test;
import use_case.get_details.*;

import java.util.List;

import static org.mockito.Mockito.*;

public class GetDetailsOutputBoundaryTest {

    @Test
    public void testPrepareSuccessView() {
        // Arrange
        GetDetailsOutputBoundary outputBoundaryMock = mock(GetDetailsOutputBoundary.class);

        GetDetailsOutputData outputData = new GetDetailsOutputData(
                "CityA", List.of("CityB", "CityC"), 25.0, "Sunny", 65,
                20.0, 30.0, 1013, 10000, false);

        // Act
        outputBoundaryMock.prepareSuccessView(outputData);

        // Assert
        verify(outputBoundaryMock, times(1)).prepareSuccessView(outputData);
    }

    @Test
    public void testPrepareFailView() {
        // Arrange
        GetDetailsOutputBoundary outputBoundaryMock = mock(GetDetailsOutputBoundary.class);

        // Act
        outputBoundaryMock.prepareFailView("Error fetching data.");

        // Assert
        verify(outputBoundaryMock, times(1)).prepareFailView("Error fetching data.");
    }
}
