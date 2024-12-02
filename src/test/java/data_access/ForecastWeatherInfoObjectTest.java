package data_access;

import entity.ForecastCity;
import entity.ForecastCityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ForecastWeatherInfoObjectTest {
    private ForecastWeatherInfoObject forecastWeatherInfoObject;
    private ForecastCityFactory mockFactory;

    @BeforeEach
    void setUp() {
        mockFactory = mock(ForecastCityFactory.class);
        forecastWeatherInfoObject = new ForecastWeatherInfoObject(mockFactory);
    }

    @Test
    void testGetWeatherForecast() {
        ForecastCity mockCity = mock(ForecastCity.class);
        when(mockFactory.create(anyString(), anyDouble(), anyString(), anyInt(), anyList())).thenReturn(mockCity);

        ForecastCity result = forecastWeatherInfoObject.getWeatherForecast("Toronto", 3);

        assertNotNull(result);
        assertEquals("Toronto", result.getLocation());
    }
}
