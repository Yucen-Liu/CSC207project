package use_case.get_forecast;

import entity.ForecastCity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.get_forecast.*;

import java.util.List;

import static org.mockito.Mockito.*;

public class GetForecastInteractorTest {

    private GetForecastDataAccessInterface dataAccessMock;
    private GetForecastOutputBoundary outputBoundaryMock;
    private GetForecastInteractor interactor;

    @BeforeEach
    public void setUp() {
        dataAccessMock = mock(GetForecastDataAccessInterface.class);
        outputBoundaryMock = mock(GetForecastOutputBoundary.class);
        interactor = new GetForecastInteractor(dataAccessMock, outputBoundaryMock);
    }

    @Test
    public void testExecuteSuccess() {
        // Arrange
        String cityName = "CityA";
        List<List<String>> mockWeatherHistory = List.of(
                List.of("25°C", "Sunny", "60%"),
                List.of("20°C", "Rainy", "70%"),
                List.of("22°C", "Cloudy", "65%")
        );
        when(dataAccessMock.getWeatherForecast(cityName, 4)).thenReturn((ForecastCity) mockWeatherHistory);

        GetForecastInputData inputData = new GetForecastInputData(cityName, List.of("CityB", "CityC"));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(dataAccessMock, times(1)).getWeatherForecast(cityName, 4);
        verify(outputBoundaryMock, times(1)).prepareSuccessView(any(GetForecastOutputData.class));
    }

    @Test
    public void testExecuteFailure() {
        // Arrange
        String cityName = "CityA";
        when(dataAccessMock.getWeatherForecast(cityName, 4)).thenThrow(new RuntimeException("Data fetch error"));

        GetForecastInputData inputData = new GetForecastInputData(cityName, List.of("CityB", "CityC"));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(dataAccessMock, times(1)).getWeatherForecast(cityName, 4);
        verify(outputBoundaryMock, times(1)).prepareFailView("Failed to retrieve forecast: Data fetch error");
    }

    @Test
    public void testExecuteEmptyCityName() {
        // Arrange
        GetForecastInputData inputData = new GetForecastInputData("", List.of("CityB", "CityC"));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(outputBoundaryMock, times(1)).prepareFailView("City name cannot be empty.");
    }
}

