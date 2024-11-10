package org.weatherapp;

// Service class to fetch weather data (currently simulated)
public class WeatherService {

    // Method to get current weather for a location
    public WeatherData getCurrentWeather(String location) {
        // Simulate fetching weather data
        // TODO: Implement API calls here
        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(location);
        weatherData.setTemperature(25.0);
        weatherData.setCondition("Sunny");
        weatherData.setHumidity(45);

        return weatherData;
    }
}
