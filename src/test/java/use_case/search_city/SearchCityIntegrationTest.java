package use_case.search_city;

import entity.CommonCity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchCityIntegrationTest {

    private SearchCityInteractor interactor;
    private String resultCityName;

    @BeforeEach
    public void setUp() {
        SearchCityDataAccessInterface dataAccess = location -> new CommonCity(location, 25.0, "Sunny", 60);

        SearchCityOutputBoundary outputBoundary = new SearchCityOutputBoundary() {
            @Override
            public void searchCityInformationView(SearchCityOutputData outputData) {
                resultCityName = outputData.getCityName();
            }

            @Override
            public void switchToGetForecastView() {}

            @Override
            public void switchToGetNearbyCitiesView() {}
        };

        interactor = new SearchCityInteractor(dataAccess, outputBoundary);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<String> savedCityNames = Arrays.asList("CityB", "CityC");
        SearchCityInputData inputData = new SearchCityInputData("CityA", savedCityNames);

        // Act
        interactor.execute(inputData);

        // Assert
        assertEquals("CityA", resultCityName);
    }
}

