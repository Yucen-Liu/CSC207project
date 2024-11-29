package org.weatherapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherGUI {
    private final WeatherService weatherService;
    private final CityStorage cityStorage;

    public WeatherGUI(WeatherService weatherService) {
        this.weatherService = weatherService;
        this.cityStorage = new CityStorage();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel locationLabel = new JLabel("Enter Location:");
        JTextField locationField = new JTextField(15);
        JButton getWeatherButton = new JButton("Get Weather");
        JButton saveCityButton = new JButton("Save City");

        inputPanel.add(locationLabel);
        inputPanel.add(locationField);
        inputPanel.add(getWeatherButton);
        inputPanel.add(saveCityButton);

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

        JList<String> savedCitiesList = new JList<>(cityStorage.getCityListModel());
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

        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText();
                if (location.isEmpty()) {
                    MessageBox.showWarningNoLoc(frame);
                    return;
                }

                // Validate city before showing
                if (CityValidator.isCityValid(location)) {
                    WeatherData weatherData = weatherService.getCurrentWeather(location);
                    updateWeatherDisplay(weatherData, locationDisplay, temperatureDisplay, conditionDisplay, humidityDisplay);
                    locationField.setText(""); // Clear the input field
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid city! Please enter a valid city.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        saveCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText();
                if (location.isEmpty()) {
                    MessageBox.showWarningNoLoc(frame);
                    return;
                }

                // Validate city before adding
                if (CityValidator.isCityValid(location)) {
                    cityStorage.addCity(location);
                    locationField.setText(""); // Clear the input field
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid city! Please enter a valid city.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(savedCitiesList), BorderLayout.WEST);
        frame.add(weatherPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void updateWeatherDisplay(WeatherData weatherData, JLabel locationDisplay, JLabel temperatureDisplay,
                                      JLabel conditionDisplay, JLabel humidityDisplay) {
        locationDisplay.setText("Location: " + weatherData.getLocation());
        temperatureDisplay.setText("Temperature: " + weatherData.getTemperature() + "°C");
        conditionDisplay.setText("Condition: " + weatherData.getCondition());
        humidityDisplay.setText("Humidity: " + weatherData.getHumidity() + "%");

    }
}
