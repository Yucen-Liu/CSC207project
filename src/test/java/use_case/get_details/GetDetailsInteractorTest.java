package use_case.get_details;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.get_details.*;
import entity.DetailedCity;

import java.util.List;

import static org.mockito.Mockito.*;

public class GetDetailsInteractorTest {

    private GetDetailsDataAccessInterface dataAccessMock;
    private GetDetailsOutputBoundary outputBoundaryMock;
    private GetDetailsInteractor interactor;

    @BeforeEach
    public void setUp() {
        dataAccessMock = mock(GetDetailsDataAccessInterface.class);
        outputBoundaryMock = mock(GetDetailsOutputBoundary.class);
        interactor = new GetDetailsInteractor(dataAccessMock, outputBoundaryMock);
    }

    @Test
    public void testExecuteSuccess() {
        // Arrange
        DetailedCity mockCity = mock(DetailedCity.class);
        when(mockCity.getTemperature()).thenReturn(25.0);
        when(mockCity.getCondition()).thenReturn("Sunny");
        when(mockCity.getHumidity()).thenReturn(65);
        when(mockCity.getTempMin()).thenReturn(20.0);
        when(mockCity.getTempMax()).thenReturn(30.0);
        when(mockCity.getPressure()).thenReturn(1013);
        when(mockCity.getVisibility()).thenReturn(10000);

        when(dataAccessMock.getDetailedWeather("CityA")).thenReturn(mockCity);

        GetDetailsInputData inputData = new GetDetailsInputData("CityA", List.of("CityB", "CityC"));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(dataAccessMock, times(1)).getDetailedWeather("CityA");
        verify(outputBoundaryMock, times(1)).prepareSuccessView(any(GetDetailsOutputData.class));
    }

    @Test
    public void testExecuteFailure() {
        // Arrange
        when(dataAccessMock.getDetailedWeather("CityA")).thenThrow(new RuntimeException("Data fetch error"));

        GetDetailsInputData inputData = new GetDetailsInputData("CityA", List.of("CityB", "CityC"));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(dataAccessMock, times(1)).getDetailedWeather("CityA");
        verify(outputBoundaryMock, times(1)).prepareFailView("Failed to retrieve forecast: Data fetch error");
    }

    @Test
    public void testExecuteEmptyCityName() {
        // Arrange
        GetDetailsInputData inputData = new GetDetailsInputData("", List.of("CityB", "CityC"));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(outputBoundaryMock, times(1)).prepareFailView("City name cannot be empty.");
    }
}
