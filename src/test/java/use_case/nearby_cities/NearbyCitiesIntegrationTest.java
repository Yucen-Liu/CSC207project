package use_case.nearby_cities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.nearby_cities.*;

import entity.NearbyCity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NearbyCitiesIntegrationTest {

    private NearbyCitiesInteractor interactor;
    private List<NearbyCity> resultNearbyCities;

    @BeforeEach
    public void setUp() {
        NearbyCitiesDataAccessInterface dataAccess = loc -> {
            List<NearbyCity> cities = new ArrayList<>();
            cities.add(new NearbyCity("CityB", 25.0, "Sunny", 60));
            cities.add(new NearbyCity("CityC", 22.5, "Rainy", 70));
            return new ArrayList<>(cities);
        };

        NearbyCitiesOutputBoundary outputBoundary = new NearbyCitiesOutputBoundary() {
            @Override
            public void switchToGetDetailsView() {}

            @Override
            public void nearbyCitiesInformationView(NearbyCitiesOutputData outputData) {
                resultNearbyCities = outputData.getNearbyCities();
            }
        };

        interactor = new NearbyCitiesInteractor(dataAccess, outputBoundary);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<String> savedCityNames = List.of("CityX", "CityY");
        NearbyCitiesInputData inputData = new NearbyCitiesInputData("CityA", savedCityNames);

        // Act
        interactor.execute(inputData);

        // Assert
        assertEquals(2, resultNearbyCities.size());
        assertEquals("CityB", resultNearbyCities.get(0).getLocation());
        assertEquals("CityC", resultNearbyCities.get(1).getLocation());
    }
}
