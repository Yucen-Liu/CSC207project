package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DetailedCityTest {

    @Test
    void testDetailedCityProperties() {
        DetailedCity city = new DetailedCity("Los Angeles", 30.0, "Clear", 50);

        assertEquals("Los Angeles", city.getLocation());
        assertEquals(30.0, city.getTemperature());
        assertEquals("Clear", city.getCondition());
        assertEquals(50, city.getHumidity());
    }
}
