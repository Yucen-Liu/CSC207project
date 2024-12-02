//package use_case.get_forecast;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import entity.ForecastCity;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class GetForecastIntegrationTest {
//
//    private GetForecastInteractor interactor;
//    private List<ForecastCity> forecastCities;
//
//    @BeforeEach
//    public void setUp() {
//        // Mock Data Access
//        GetForecastDataAccessInterface dataAccess = new GetForecastDataAccessInterface() {
//            @Override
//            public List<ForecastCity> getForecast(String cityName) {
//                return Arrays.asList(
//                        new ForecastCity("CityA", 20.0, "Sunny", 50),
//                        new ForecastCity("CityB", 15.0, "Cloudy", 60),
//                        new ForecastCity("CityC", 10.0, "Rainy", 70)
//                );
//            }
//        };
//
//        // Concrete OutputBoundary Implementation
//        GetForecastOutputBoundary outputBoundary = new GetForecastOutputBoundary() {
//            @Override
//            public void presentForecast(GetForecastOutputData outputData) {
//                forecastCities = outputData.getForecastCities();
//            }
//        };
//
//        interactor = new GetForecastInteractor(dataAccess, outputBoundary);
//    }
//
//    @Test
//    public void testGetForecast() {
//        // Arrange
//        GetForecastInputData inputData = new GetForecastInputData("CityA", Arrays.asList("CityA", "CityB", "CityC"));
//
//        // Act
//        interactor.execute(inputData);
//
//        // Assert
//        assertEquals(3, forecastCities.size());
//        assertEquals("CityA", forecastCities.get(0).getLocation());
//        assertEquals(20.0, forecastCities.get(0).getTemperature());
//        assertEquals("Sunny", forecastCities.get(0).getCondition());
//        assertEquals(50, forecastCities.get(0).getHumidity());
//    }
//}
