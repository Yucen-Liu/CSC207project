package org.weatherapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// GUI class for the weather app
public class WeatherGUI {
    private final WeatherService weatherService;
    private final DefaultListModel<String> savedCitiesModel; // Model for saved cities list

    public WeatherGUI(WeatherService weatherService) {
        this.weatherService = weatherService;
        this.savedCitiesModel = new DefaultListModel<>(); // Initialize the list model
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Input panel with label, text field, and save button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel locationLabel = new JLabel("Enter Location:");
        JTextField locationField = new JTextField(15);
        JButton getWeatherButton = new JButton("Get Weather");
        JButton saveCityButton = new JButton("Save City"); // Button to save city

        inputPanel.add(locationLabel);
        inputPanel.add(locationField);
        inputPanel.add(getWeatherButton);
        inputPanel.add(saveCityButton);

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

        // List to display saved cities
        JList<String> savedCitiesList = new JList<>(savedCitiesModel);
        savedCitiesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        savedCitiesList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedCity = savedCitiesList.getSelectedValue();
                if (selectedCity != null) {
                    WeatherData weatherData = weatherService.getCurrentWeather(selectedCity);
                    updateWeatherDisplay(weatherData, locationDisplay, temperatureDisplay, conditionDisplay, humidityDisplay);
                }
            }
        });

        // Action listener for "Get Weather" button
        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText();
                if (location.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a location.");
                    return;
                }

                WeatherData weatherData = weatherService.getCurrentWeather(location);
                updateWeatherDisplay(weatherData, locationDisplay, temperatureDisplay, conditionDisplay, humidityDisplay);
            }
        });

        // Action listener for "Save City" button
        saveCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText();
                if (!location.isEmpty() && !savedCitiesModel.contains(location)) {
                    savedCitiesModel.addElement(location);
                    locationField.setText("");
                }
            }
        });

        // Adding components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(savedCitiesList), BorderLayout.WEST); // Add the saved cities list
        frame.add(weatherPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Helper method to update weather display labels
    private void updateWeatherDisplay(WeatherData weatherData, JLabel locationDisplay, JLabel temperatureDisplay,
                                      JLabel conditionDisplay, JLabel humidityDisplay) {
        locationDisplay.setText("Location: " + weatherData.getLocation());
        temperatureDisplay.setText("Temperature: " + weatherData.getTemperature() + "°C");
        conditionDisplay.setText("Condition: " + weatherData.getCondition());
        humidityDisplay.setText("Humidity: " + weatherData.getHumidity() + "%");
    }
}
