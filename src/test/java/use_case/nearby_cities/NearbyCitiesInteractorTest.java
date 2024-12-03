package use_case.nearby_cities;

import data_access.NearbyCityWeatherAccessObject;
import entity.NearbyCity;
import entity.NearbyCityFactory;
import interface_adapter.nearby_cities.NearbyCitiesController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NearbyCitiesInteractorTest {

    @Test
    void successTest() {
        // Prepare input data
        List<String> savedCities = new ArrayList<>();
        savedCities.add("Toronto");
        NearbyCitiesInputData inputData = new NearbyCitiesInputData("Toronto", savedCities);

        // Prepare data access mock
        NearbyCitiesDataAccessInterface nearbyCityRepository = new NearbyCityWeatherAccessObject(new NearbyCityFactory());

        // Create output boundary
        NearbyCitiesOutputBoundary successPresenter = new NearbyCitiesOutputBoundary() {
            @Override
            public void switchToGetDetailsView() {
                // Empty implementation for the test
            }

            @Override
            public void nearbyCitiesInformationView(NearbyCitiesOutputData nearbyCitiesOutputData) {
                assertNotNull(nearbyCitiesOutputData);
                assertTrue(nearbyCitiesOutputData.getNearbyCities().size() > 0);
            }
        };

        // Create the interactor
        NearbyCitiesInputBoundary interactor = new NearbyCitiesInteractor(nearbyCityRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void testControllerSwitchToGetDetailsView() {
        // Mock dependencies
        NearbyCitiesDataAccessInterface nearbyCityRepository = mock(NearbyCitiesDataAccessInterface.class);
        NearbyCitiesOutputBoundary outputBoundary = mock(NearbyCitiesOutputBoundary.class);
        NearbyCitiesInputBoundary interactor = new NearbyCitiesInteractor(nearbyCityRepository, outputBoundary);

        // Create controller with mocked interactor
        NearbyCitiesController controller = new NearbyCitiesController(interactor);

        // Call the method directly
        controller.switchGetDetailsView();

        // Verify that switchToGetDetailsView() was called in the interactor
        verify(outputBoundary, times(1)).switchToGetDetailsView();
    }

    @Test
    void testNearbyCitiesOutputDataAccessors() {
        // Sample data for testing
        String cityName = "Toronto";
        List<String> savedCityNames = new ArrayList<>();
        savedCityNames.add("New York");
        savedCityNames.add("Chicago");

        List<NearbyCity> nearbyCities = new ArrayList<>();
        nearbyCities.add(new NearbyCity("Hamilton", 20.5, "Sunny", 65));
        nearbyCities.add(new NearbyCity("Mississauga", 18.0, "Cloudy", 70));

        // Create NearbyCitiesOutputData instance
        NearbyCitiesOutputData outputData = new NearbyCitiesOutputData(nearbyCities, cityName, savedCityNames);

        // Verify accessors (getters)
        assertEquals(cityName, outputData.getCityName());
        assertEquals(savedCityNames, outputData.getSavedCityNames());
        assertEquals(nearbyCities, outputData.getNearbyCities());

        // Verify derived lists
        List<String> expectedNearbyCityNames = List.of("Hamilton", "Mississauga");
        List<Double> expectedTemperatures = List.of(20.5, 18.0);
        List<String> expectedConditions = List.of("Sunny", "Cloudy");
        List<Integer> expectedHumidities = List.of(65, 70);

        assertEquals(expectedNearbyCityNames, outputData.getNearbyCityNames());
        assertEquals(expectedTemperatures, outputData.getNearbyCitiesTemperature());
        assertEquals(expectedConditions, outputData.getNearbyCitiesCondition());
        assertEquals(expectedHumidities, outputData.getNearbyCitiesHumidity());
    }
}
