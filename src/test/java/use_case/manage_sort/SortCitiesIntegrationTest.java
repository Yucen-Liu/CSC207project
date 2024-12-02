//package use_case.manage_sort;
//
//import entity.CommonCity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import use_case.manage_sort.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class SortCitiesIntegrationTest {
//
//    private SortCitiesInteractor interactor;
//    private List<CommonCity> sortedCities;
//
//    @BeforeEach
//    public void setUp() {
//        // Mock Data Access
//        SortCitiesDataAccessInterface dataAccess = cityName -> {
//            switch (cityName) {
//                case "CityA": return new CommonCity("CityA", 20.0, "Sunny", 50);
//                case "CityB": return new CommonCity("CityB", 15.0, "Cloudy", 60);
//                case "CityC": return new CommonCity("CityC", 10.0, "Rainy", 70);
//                default: throw new IllegalArgumentException("City not found");
//            }
//        };
//
//        // Concrete OutputBoundary Implementation
//        SortCitiesOutputBoundary outputBoundary = new SortCitiesOutputBoundary() {
//            @Override
//            public void presentSortedCities(SortCitiesOutputData outputData) {
//                sortedCities = outputData.getSortedCities();
//            }
//        };
//
//        interactor = new SortCitiesInteractor(dataAccess, outputBoundary);
//    }
//
//    @Test
//    public void testSortByHumidity() {
//        // Arrange
//        SortCitiesInputData inputData = new SortCitiesInputData("humidity", Arrays.asList("CityA", "CityB", "CityC"));
//
//        // Act
//        interactor.execute(inputData);
//
//        // Assert
//        assertEquals("CityA", sortedCities.get(0).getLocation());
//        assertEquals("CityB", sortedCities.get(1).getLocation());
//        assertEquals("CityC", sortedCities.get(2).getLocation());
//    }
//}
//
//
