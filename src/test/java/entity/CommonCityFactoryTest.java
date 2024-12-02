package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommonCityFactoryTest {

    @Test
    void testCreateCity() {
        CityFactory factory = new CommonCityFactory();
        City city = factory.create("Vancouver", 15.0, "Rainy", 80);

        assertEquals("Vancouver", city.getLocation());
        assertEquals(15.0, city.getTemperature());
        assertEquals("Rainy", city.getCondition());
        assertEquals(80, city.getHumidity());
    }
}
