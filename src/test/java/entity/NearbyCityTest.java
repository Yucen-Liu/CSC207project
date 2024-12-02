package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NearbyCityTest {

    @Test
    void testNearbyCityProperties() {
        NearbyCity city = new NearbyCity("Seattle", 18.0, "Foggy", 75);

        assertEquals("Seattle", city.getLocation());
        assertEquals(18.0, city.getTemperature());
        assertEquals("Foggy", city.getCondition());
        assertEquals(75, city.getHumidity());
    }
}
