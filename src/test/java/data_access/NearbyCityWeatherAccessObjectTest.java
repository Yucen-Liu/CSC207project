package data_access;

import entity.NearbyCity;
import entity.NearbyCityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NearbyCityWeatherAccessObjectTest {
    private NearbyCityWeatherAccessObject nearbyCityWeatherAccessObject;
    private NearbyCityFactory mockFactory;

    @BeforeEach
    void setUp() {
        mockFactory = mock(NearbyCityFactory.class);
        nearbyCityWeatherAccessObject = new NearbyCityWeatherAccessObject(mockFactory);
    }

    @Test
    void testGetNearbyCities() {
        NearbyCity mockCity = mock(NearbyCity.class);
        when(mockFactory.create(anyString(), anyDouble(), anyString(), anyInt())).thenReturn(mockCity);

        ArrayList<NearbyCity> result = nearbyCityWeatherAccessObject.getNearbyCities("Seattle");

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
