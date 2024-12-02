package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import entity.DetailedCity;
import entity.DetailedCityFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetailedCityFactoryTest {

    @Test
    public void testCreateDetailedCityWithAllAttributes() {
        // Arrange
        DetailedCityFactory factory = new DetailedCityFactory();
        String location = "CityB";
        double temperature = 28.0;
        String condition = "Cloudy";
        int humidity = 70;
        double tempMin = 25.0;
        double tempMax = 30.0;
        int pressure = 1012;
        int visibility = 9000;

        // Act
        DetailedCity city = factory.create(location, temperature, condition, humidity, tempMax, tempMin, pressure, visibility);

        // Assert
        assertEquals(location, city.getLocation());
        assertEquals(temperature, city.getTemperature());
        assertEquals(condition, city.getCondition());
        assertEquals(humidity, city.getHumidity());
        assertEquals(tempMin, city.getTempMin());
        assertEquals(tempMax, city.getTempMax());
        assertEquals(pressure, city.getPressure());
        assertEquals(visibility, city.getVisibility());
    }

    @Test
    public void testCreateDetailedCityWithMinimalAttributes() {
        // Arrange
        DetailedCityFactory factory = new DetailedCityFactory();
        String location = "CityC";
        double temperature = 22.5;
        String condition = "Rainy";
        int humidity = 85;

        // Act
        DetailedCity city = factory.create(location, temperature, condition, humidity);

        // Assert
        assertEquals(location, city.getLocation());
        assertEquals(temperature, city.getTemperature());
        assertEquals(condition, city.getCondition());
        assertEquals(humidity, city.getHumidity());

        // Default values for optional attributes
        assertEquals(-1000000, city.getTempMin());
        assertEquals(-1000000, city.getTempMax());
        assertEquals(-1000000, city.getPressure());
        assertEquals(-1000000, city.getVisibility());
    }
}

