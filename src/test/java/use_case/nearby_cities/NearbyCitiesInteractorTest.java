package use_case.nearby_cities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.NearbyCity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class NearbyCitiesInteractorTest {

    private NearbyCitiesDataAccessInterface dataAccessMock;
    private NearbyCitiesOutputBoundary outputBoundaryMock;
    private NearbyCitiesInteractor interactor;

    @BeforeEach
    public void setUp() {
        dataAccessMock = mock(NearbyCitiesDataAccessInterface.class);
        outputBoundaryMock = mock(NearbyCitiesOutputBoundary.class);
        interactor = new NearbyCitiesInteractor(dataAccessMock, outputBoundaryMock);
    }

    @Test
    public void testExecute() {
        // Arrange
        NearbyCity nearbyCity1 = mock(NearbyCity.class);
        NearbyCity nearbyCity2 = mock(NearbyCity.class);

        when(nearbyCity1.getLocation()).thenReturn("CityB");
        when(nearbyCity2.getLocation()).thenReturn("CityC");

        ArrayList<NearbyCity> nearbyCities = new ArrayList<>();
        nearbyCities.add(nearbyCity1);
        nearbyCities.add(nearbyCity2);

        when(dataAccessMock.getNearbyCities("CityA")).thenReturn(nearbyCities);

        List<String> savedCityNames = List.of("CityX", "CityY");
        NearbyCitiesInputData inputData = new NearbyCitiesInputData("CityA", savedCityNames);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(dataAccessMock, times(1)).getNearbyCities("CityA");
        verify(outputBoundaryMock, times(1)).nearbyCitiesInformationView(any(NearbyCitiesOutputData.class));
    }

    @Test
    public void testSwitchToGetDetailsView() {
        // Act
        interactor.switchToGetDetailsView();

        // Assert
        verify(outputBoundaryMock, times(1)).switchToGetDetailsView();
    }
}
