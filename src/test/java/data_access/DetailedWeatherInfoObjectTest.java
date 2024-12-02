package data_access;

import entity.DetailedCity;
import entity.DetailedCityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DetailedWeatherInfoObjectTest {
    private DetailedWeatherInfoObject detailedWeatherInfoObject;
    private DetailedCityFactory mockFactory;

    @BeforeEach
    void setUp() {
        mockFactory = mock(DetailedCityFactory.class);
        detailedWeatherInfoObject = new DetailedWeatherInfoObject(mockFactory);
    }

    @Test
    void testGetDetailedWeatherSuccess() {
        DetailedCity mockCity = new DetailedCity("New York", 18.5, "Cloudy", 70);
        when(mockFactory.create(anyString(), anyDouble(), anyString(), anyInt())).thenReturn(mockCity);

        DetailedCity result = detailedWeatherInfoObject.getDetailedWeather("New York");
        assertNotNull(result);
        assertEquals("New York", result.getLocation());
    }

    @Test
    void testGetDetailedWeatherFailure() {
        assertNull(detailedWeatherInfoObject.getDetailedWeather("InvalidCity"));
    }
}
