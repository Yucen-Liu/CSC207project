package entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForecastCityFactoryTest {

    @Test
    void testCreateCityWithDefaultForecast() {
        ForecastCityFactory factory = new ForecastCityFactory();
        ForecastCity city = factory.create("Vancouver", 15.0, "Cloudy", 70);

        assertEquals("Vancouver", city.getLocation());
        assertEquals(15.0, city.getTemperature());
        assertEquals("Cloudy", city.getCondition());
        assertEquals(70, city.getHumidity());
        assertEquals(3, city.getForecast().size()); // Default history
    }

    @Test
    void testCreateCityWithCustomForecast() {
        ForecastCityFactory factory = new ForecastCityFactory();
        List<List<String>> forecast = Arrays.asList(
                Arrays.asList("10.0", "Rainy", "80"),
                Arrays.asList("12.0", "Cloudy", "75"),
                Arrays.asList("15.0", "Sunny", "60")
        );

        ForecastCity city = factory.create("Calgary", 20.0, "Clear", 50, forecast);

        assertEquals("Calgary", city.getLocation());
        assertEquals(20.0, city.getTemperature());
        assertEquals("Clear", city.getCondition());
        assertEquals(50, city.getHumidity());
        assertEquals(forecast, city.getForecast());
    }

    @Test
    void testHistoryCertainHour() {
        ForecastCityFactory factory = new ForecastCityFactory();
        List<String> history = factory.historyCertainHour(22.5, "Clear", 45);

        assertEquals(Arrays.asList("22.5", "Clear", "45"), history);
    }
}
