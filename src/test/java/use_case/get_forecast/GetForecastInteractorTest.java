//package use_case.get_forecast;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import use_case.get_forecast.*;
//import entity.ForecastCity;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class GetForecastInteractorTest {
//
//    private GetForecastDataAccessInterface dataAccessMock;
//    private GetForecastOutputBoundary outputBoundaryMock;
//    private GetForecastInteractor interactor;
//
//    @BeforeEach
//    public void setUp() {
//        dataAccessMock = mock(GetForecastDataAccessInterface.class);
//        outputBoundaryMock = mock(GetForecastOutputBoundary.class);
//        interactor = new GetForecastInteractor(dataAccessMock, outputBoundaryMock);
//    }
//
//    @Test
//    public void testGetForecast() {
//        // Arrange
//        ForecastCity cityA = new ForecastCity("CityA", 20.0, "Sunny", 50);
//        ForecastCity cityB = new ForecastCity("CityB", 15.0, "Cloudy", 60);
//        ForecastCity cityC = new ForecastCity("CityC", 10.0, "Rainy", 70);
//
//        when(dataAccessMock.getForecast("CityA")).thenReturn(Arrays.asList(cityA, cityB, cityC));
//
//        GetForecastInputData inputData = new GetForecastInputData("CityA", Arrays.asList("CityA", "CityB", "CityC"));
//
//        // Act
//        interactor.execute(inputData);
//
//        // Assert
//        verify(outputBoundaryMock, times(1)).presentForecast(argThat(outputData -> {
//            List<ForecastCity> forecastCities = outputData.getForecastCities();
//            return forecastCities.size() == 3 &&
//                    forecastCities.get(0).equals(cityA) &&
//                    forecastCities.get(1).equals(cityB) &&
//                    forecastCities.get(2).equals(cityC);
//        }));
//    }
//}
//
