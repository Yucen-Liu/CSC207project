package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import entity.DetailedCity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetailedCityTest {

    @Test
    public void testDetailedCityAttributes() {
        // Arrange
        String location = "CityA";
        double temperature = 25.5;
        String condition = "Sunny";
        int humidity = 60;
        double tempMin = 20.0;
        double tempMax = 30.0;
        int pressure = 1013;
        int visibility = 10000;

        // Act
        DetailedCity city = new DetailedCity(location, temperature, condition, humidity, tempMax, tempMin, pressure, visibility);

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
}

