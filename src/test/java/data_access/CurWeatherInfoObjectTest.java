package data_access;

import entity.City;
import entity.CommonCityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurWeatherInfoObjectIntegrationTest {
    private CurWeatherInfoObject curWeatherInfoObject;

    @BeforeEach
    void setUp() {
        // Use the real CityFactory and HTTP client
        CommonCityFactory cityFactory = new CommonCityFactory();
        curWeatherInfoObject = new CurWeatherInfoObject(cityFactory);
    }

    @Test
    void testGetCurWeatherWithValidCity() {
        // Provide a real city name
        String cityName = "Toronto";
        City result = curWeatherInfoObject.getCurWeather(cityName);

        // Assertions
        assertNotNull(result, "The returned City object should not be null");
        assertEquals("Toronto", result.getLocation(), "The city name should match the input");
        assertTrue(result.getTemperature() > -50 && result.getTemperature() < 50, "Temperature should be in a realistic range");
        assertNotNull(result.getCondition(), "Condition should not be null");
        assertTrue(result.getHumidity() >= 0 && result.getHumidity() <= 100, "Humidity should be in a valid range");
    }

    @Test
    void testGetCurWeatherWithInvalidCity() {
        // Provide an invalid city name
        String invalidCity = "addddd";

        Exception exception = assertThrows(RuntimeException.class, () -> curWeatherInfoObject.getCurWeather(invalidCity));
        assertTrue(exception.getMessage().contains("Error retrieving current weather"), "Expected error message for invalid city");
    }
}
