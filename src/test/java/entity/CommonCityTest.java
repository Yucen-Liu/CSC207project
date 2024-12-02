package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommonCityTest {

    @Test
    void testCommonCityProperties() {
        CommonCity city = new CommonCity("Toronto", 25.5, "Sunny", 65);

        assertEquals("Toronto", city.getLocation());
        assertEquals(25.5, city.getTemperature());
        assertEquals("Sunny", city.getCondition());
        assertEquals(65, city.getHumidity());
    }
}
