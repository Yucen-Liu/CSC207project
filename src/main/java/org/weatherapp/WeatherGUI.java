package org.weatherapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI class for the weather app
public class WeatherGUI {
    private final WeatherService weatherService;

    public WeatherGUI(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Input panel with label and text field
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel locationLabel = new JLabel("Enter Location:");
        JTextField locationField = new JTextField(15);

        inputPanel.add(locationLabel);
        inputPanel.add(locationField);

        // Button to fetch weather data
        JButton getWeatherButton = new JButton("Get Weather");

        // Panel to display weather info
        JPanel weatherPanel = new JPanel();
        weatherPanel.setLayout(new GridLayout(4, 1));

        JLabel locationDisplay = new JLabel("Location: ");
        JLabel temperatureDisplay = new JLabel("Temperature: ");
        JLabel conditionDisplay = new JLabel("Condition: ");
        JLabel humidityDisplay = new JLabel("Humidity: ");

        weatherPanel.add(locationDisplay);
        weatherPanel.add(temperatureDisplay);
        weatherPanel.add(conditionDisplay);
        weatherPanel.add(humidityDisplay);

        // Action listener for button to fetch and display weather info
        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText();
                if (location.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a location.");
                    return;
                }

                WeatherData weatherData = weatherService.getCurrentWeather(location);

                locationDisplay.setText("Location: " + weatherData.getLocation());
                temperatureDisplay.setText("Temperature: " + weatherData.getTemperature() + "°C");
                conditionDisplay.setText("Condition: " + weatherData.getCondition());
                humidityDisplay.setText("Humidity: " + weatherData.getHumidity() + "%");
            }
        });

        // Adding components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(getWeatherButton, BorderLayout.CENTER);
        frame.add(weatherPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
