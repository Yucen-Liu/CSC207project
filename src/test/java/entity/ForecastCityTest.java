package entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForecastCityTest {

    @Test
    void testForecastCityProperties() {
        List<List<String>> forecast = new ArrayList<>();
        forecast.add(Arrays.asList("20.0", "Sunny", "50"));
        forecast.add(Arrays.asList("18.0", "Cloudy", "60"));
        forecast.add(Arrays.asList("16.0", "Rainy", "70"));

        ForecastCity city = new ForecastCity("Toronto", 25.0, "Sunny", 55, forecast);

        assertEquals("Toronto", city.getLocation());
        assertEquals(25.0, city.getTemperature());
        assertEquals("Sunny", city.getCondition());
        assertEquals(55, city.getHumidity());
        assertEquals(forecast, city.getForecast());
    }
}
