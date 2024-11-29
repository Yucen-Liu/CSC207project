package org.weatherapp.use_cases;

import org.weatherapp.entities.WeatherData;

// Service class to fetch weather data
public class WeatherService {
    private final WeatherInformation weatherInformation;

    public WeatherService(){
        weatherInformation = new WeatherInformation();
    }

    // Method to get current weather for a location
    public WeatherInformation getCurrentWeather(String loc) {
        //Get weather data from WeatherData and store in weatherInformation Data Structure to be displayed
        WeatherData weatherData = new WeatherData(loc);
        weatherInformation.setLocation(weatherData.getLocation());
        weatherInformation.setTemperature(weatherData.getTemperature());
        weatherInformation.setCondition(weatherData.getCondition());
        weatherInformation.setHumidity(weatherData.getHumidity());

        return weatherInformation;
    }
}
