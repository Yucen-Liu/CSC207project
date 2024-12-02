package data_access;

import entity.DetailedCity;
import entity.DetailedCityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import data_access.DetailedWeatherInfoObject;
import entity.DetailedCity;
import entity.DetailedCityFactory;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class DetailedWeatherInfoObjectTest {

    private MockWebServer mockWebServer;
    private DetailedWeatherInfoObject weatherInfoObject;

    @BeforeEach
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        DetailedCityFactory cityFactory = new DetailedCityFactory();
        weatherInfoObject = new DetailedWeatherInfoObject(cityFactory);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

    @Test
    public void testGetDetailedWeatherSuccess() {
        // Arrange
        JSONObject mainData = new JSONObject();
        mainData.put("temp", 293.15);
        mainData.put("temp_min", 290.15);
        mainData.put("temp_max", 295.15);
        mainData.put("humidity", 65);
        mainData.put("pressure", 1012);

        JSONObject weatherData = new JSONObject();
        weatherData.put("description", "clear sky");

        JSONObject responseData = new JSONObject();
        responseData.put("name", "CityA");
        responseData.put("visibility", 10000);
        responseData.put("main", mainData);
        responseData.put("weather", new JSONObject[]{weatherData});

        mockWebServer.enqueue(new MockResponse()
                .setBody(responseData.toString())
                .addHeader("Content-Type", "application/json"));

        String testUrl = mockWebServer.url("/data/2.5/weather").toString();

        // Act
        DetailedCity result = weatherInfoObject.getDetailedWeather("CityA");

        // Assert
        assertNotNull(result);
        assertEquals("CityA", result.getLocation());
        assertEquals(20.0, result.getTemperature());
        assertEquals("clear sky", result.getCondition());
        assertEquals(65, result.getHumidity());
        assertEquals(17.0, result.getTempMin());
        assertEquals(22.0, result.getTempMax());
        assertEquals(1012, result.getPressure());
        assertEquals(10000, result.getVisibility());
    }

    @Test
    public void testGetDetailedWeatherFailure() {
        // Arrange
        mockWebServer.enqueue(new MockResponse().setResponseCode(404));

        String testUrl = mockWebServer.url("/data/2.5/weather").toString();

        // Act
        DetailedCity result = weatherInfoObject.getDetailedWeather("InvalidCity");

        // Assert
        assertNull(result);
    }
}

