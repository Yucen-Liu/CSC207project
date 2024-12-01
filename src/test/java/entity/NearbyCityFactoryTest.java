package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NearbyCityFactoryTest {

    @Test
    void testCreateCity() {
        NearbyCityFactory factory = new NearbyCityFactory();
        NearbyCity city = factory.create("Portland", 20.0, "Clear", 65);

        assertEquals("Portland", city.getLocation());
        assertEquals(20.0, city.getTemperature());
        assertEquals("Clear", city.getCondition());
        assertEquals(65, city.getHumidity());
    }
}
