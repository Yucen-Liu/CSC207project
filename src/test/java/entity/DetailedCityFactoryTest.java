package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DetailedCityFactoryTest {

    @Test
    void testCreateCity() {
        CityFactory factory = new DetailedCityFactory();
        City city = factory.create("Chicago", 10.0, "Windy", 55);

        assertEquals("Chicago", city.getLocation());
        assertEquals(10.0, city.getTemperature());
        assertEquals("Windy", city.getCondition());
        assertEquals(55, city.getHumidity());
    }
}
