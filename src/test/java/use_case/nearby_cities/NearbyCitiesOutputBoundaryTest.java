package use_case.nearby_cities;

import org.junit.jupiter.api.Test;
import use_case.nearby_cities.*;

import entity.NearbyCity;

import java.util.List;

import static org.mockito.Mockito.*;

public class NearbyCitiesOutputBoundaryTest {

    @Test
    public void testNearbyCitiesInformationView() {
        // Arrange
        NearbyCitiesOutputBoundary outputBoundaryMock = mock(NearbyCitiesOutputBoundary.class);

        List<NearbyCity> nearbyCities = List.of(
                new NearbyCity("CityB", 25.0, "Sunny", 60),
                new NearbyCity("CityC", 22.5, "Rainy", 70)
        );
        List<String> savedCityNames = List.of("CityX", "CityY");

        NearbyCitiesOutputData outputData = new NearbyCitiesOutputData(nearbyCities, "CityA", savedCityNames);

        // Act
        outputBoundaryMock.nearbyCitiesInformationView(outputData);

        // Assert
        verify(outputBoundaryMock, times(1)).nearbyCitiesInformationView(outputData);
    }
}
