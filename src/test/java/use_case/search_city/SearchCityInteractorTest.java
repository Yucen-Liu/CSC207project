package use_case.search_city;

import entity.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;


public class SearchCityInteractorTest {

    private SearchCityDataAccessInterface dataAccessMock;
    private SearchCityOutputBoundary outputBoundaryMock;
    private SearchCityInteractor interactor;

    @BeforeEach
    public void setUp() {
        dataAccessMock = mock(SearchCityDataAccessInterface.class);
        outputBoundaryMock = mock(SearchCityOutputBoundary.class);
        interactor = new SearchCityInteractor(dataAccessMock, outputBoundaryMock);
    }

    @Test
    public void testExecuteValidCity() {
        // Arrange
        City mockCity = mock(City.class);
        when(mockCity.getLocation()).thenReturn("CityA");
        when(mockCity.getTemperature()).thenReturn(25.5);
        when(mockCity.getCondition()).thenReturn("Sunny");
        when(mockCity.getHumidity()).thenReturn(60);

        when(dataAccessMock.getCurWeather("CityA")).thenReturn(mockCity);

        List<String> savedCityNames = Arrays.asList("CityB", "CityC");
        SearchCityInputData inputData = new SearchCityInputData("CityA", savedCityNames);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(dataAccessMock, times(1)).getCurWeather("CityA");
        verify(outputBoundaryMock, times(1)).searchCityInformationView(any(SearchCityOutputData.class));
    }

    @Test
    public void testSwitchToGetForecastView() {
        // Act
        interactor.switchToGetForecastView();

        // Assert
        verify(outputBoundaryMock, times(1)).switchToGetForecastView();
    }

    @Test
    public void testSwitchToGetNearbyCitiesView() {
        // Act
        interactor.switchToGetNearbyCitiesView();

        // Assert
        verify(outputBoundaryMock, times(1)).switchToGetNearbyCitiesView();
    }
}

