package org.weatherapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interface_adapter.manage_cities.ManageCitiesController;
import use_case.manage_cities.FavoriteCitiesInteractor;
import data_access.FavoriteCityStorageImpl;
import view.ManageCityView;

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

        // Input Panel
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

        // Weather Display Panel
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

        // Saved Cities List
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

        // City List Panel with "Manage Cities" Button
        JPanel cityListPanel = new JPanel();
        cityListPanel.setLayout(new BorderLayout());

        JButton manageCitiesButton = new JButton("Manage Cities");
        manageCitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageCities();
            }
        });

        cityListPanel.add(manageCitiesButton, BorderLayout.NORTH);
        cityListPanel.add(new JScrollPane(savedCitiesList), BorderLayout.CENTER);

        // Get Weather Button Action
        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText();
                if (location.isEmpty()) {
                    MessageBox.showWarningNoLoc(frame);
                    return;
                }

                if (CityValidator.isCityValid(location)) {
                    WeatherData weatherData = weatherService.getCurrentWeather(location);
                    updateWeatherDisplay(weatherData, locationDisplay, temperatureDisplay, conditionDisplay, humidityDisplay);
                    locationField.setText(""); // Clear the input field
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid city! Please enter a valid city.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Save City Button Action
        saveCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText();
                if (location.isEmpty()) {
                    MessageBox.showWarningNoLoc(frame);
                    return;
                }

                if (CityValidator.isCityValid(location)) {
                    cityStorage.addCity(location);
                    locationField.setText(""); // Clear the input field
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid city! Please enter a valid city.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adding Components to Frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(cityListPanel, BorderLayout.WEST);
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

    private void manageCities() {
        // Link to the ManageCityView window
        ManageCitiesController controller = new ManageCitiesController(new FavoriteCitiesInteractor(new FavoriteCityStorageImpl()));
        ManageCityView manageCityView = new ManageCityView(controller);
        manageCityView.setVisible(true); // Show the ManageCityView window
    }
}
