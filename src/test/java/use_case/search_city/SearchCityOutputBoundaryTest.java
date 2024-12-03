//package use_case.search_city;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static org.mockito.Mockito.*;
//
//public class SearchCityOutputBoundaryTest {
//
//    @Test
//    public void testSearchCityInformationView() {
//        // Arrange
//        SearchCityOutputBoundary outputBoundaryMock = mock(SearchCityOutputBoundary.class);
//        SearchCityOutputData outputData = new SearchCityOutputData("CityA", 25.5, "Sunny", 60, Arrays.asList("CityB", "CityC"));
//
//        // Act
//        outputBoundaryMock.searchCityInformationView(outputData);
//
//        // Assert
//        verify(outputBoundaryMock, times(1)).searchCityInformationView(outputData);
//    }
//}
