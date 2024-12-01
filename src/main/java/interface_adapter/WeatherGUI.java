package interface_adapter;

import entity.WeatherData;
import use_case.cities.ManageCitiesInteractor;
import use_case.weather.FetchWeatherData;
import view.GetDetailsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WeatherGUI {
    private final FetchWeatherData fetchWeatherData;
    private final ManageCitiesInteractor manageCitiesInteractor;

    // Declare cityListModel as a class-level field
    private DefaultListModel<String> cityListModel;

    public WeatherGUI(FetchWeatherData fetchWeatherData, ManageCitiesInteractor manageCitiesInteractor) {
        this.fetchWeatherData = fetchWeatherData;
        this.manageCitiesInteractor = manageCitiesInteractor;
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel locationLabel = new JLabel("Enter Location:");
        JTextField locationField = new JTextField(15);
        JButton getWeatherButton = new JButton("Get Weather");
        JButton saveCityButton = new JButton("Save City");
        inputPanel.add(locationLabel);
        inputPanel.add(locationField);
        inputPanel.add(getWeatherButton);
        inputPanel.add(saveCityButton);

        // Weather Display Panel
        JPanel weatherPanel = new JPanel(new GridLayout(4, 1));
        JLabel locationDisplay = new JLabel("Location: ");
        JLabel temperatureDisplay = new JLabel("Temperature: ");
        JLabel conditionDisplay = new JLabel("Condition: ");
        JLabel humidityDisplay = new JLabel("Humidity: ");
        weatherPanel.add(locationDisplay);
        weatherPanel.add(temperatureDisplay);
        weatherPanel.add(conditionDisplay);
        weatherPanel.add(humidityDisplay);

        // Saved Cities List
        cityListModel = new DefaultListModel<>(); // Initialize the cityListModel here
        JList<String> savedCitiesList = new JList<>(cityListModel);
        JScrollPane cityListScrollPane = new JScrollPane(savedCitiesList);

        // Add MouseListener for Single-Click to Show Weather
        savedCitiesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Single-click detected
                    String selectedCity = savedCitiesList.getSelectedValue();
                    if (selectedCity != null) {
                        WeatherData weatherData = fetchWeatherData.fetchWeather(selectedCity);
                        if (weatherData != null) {
                            updateWeatherDisplay(weatherData, locationDisplay, temperatureDisplay, conditionDisplay, humidityDisplay);
                        } else {
                            showMessage("Error fetching weather for " + selectedCity, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        // Remove City Button
        JButton removeCityButton = new JButton("Remove City");
        removeCityButton.setEnabled(false); // Initially disabled

        // Enable/Disable Remove City button based on selection
        savedCitiesList.addListSelectionListener(e -> {
            removeCityButton.setEnabled(!savedCitiesList.isSelectionEmpty());
        });

        // Add ActionListener to Remove City button
        removeCityButton.addActionListener(e -> {
            String selectedCity = savedCitiesList.getSelectedValue();
            if (selectedCity != null) {
                if (manageCitiesInteractor.removeCity(selectedCity)) {
                    cityListModel.removeElement(selectedCity); // Remove from UI list
                    showMessage("City removed successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    showMessage("Error removing city.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // City List Panel
        JPanel cityListPanel = new JPanel(new BorderLayout());
        cityListPanel.add(cityListScrollPane, BorderLayout.CENTER);
        cityListPanel.add(removeCityButton, BorderLayout.NORTH);

        // Button Actions
        getWeatherButton.addActionListener(e -> {
            String location = locationField.getText().trim();
            if (location.isEmpty()) {
                showMessage("Please enter a location!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            WeatherData weatherData = fetchWeatherData.fetchWeather(location);
            if (weatherData != null) {
                updateWeatherDisplay(weatherData, locationDisplay, temperatureDisplay, conditionDisplay, humidityDisplay);
            } else {
                showMessage("Invalid city or error fetching weather!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        saveCityButton.addActionListener(e -> {
            String location = locationField.getText().trim();
            if (location.isEmpty()) {
                showMessage("Please enter a location!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Local validation for city name format
            if (!manageCitiesInteractor.isCityValid(location)) {
                showMessage("Invalid city name format!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validate the city through API
            WeatherData weatherData = fetchWeatherData.fetchWeather(location);
            if (weatherData == null) {
                showMessage("City not found or invalid!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Attempt to add the city
            if (manageCitiesInteractor.addCity(location)) {
                cityListModel.addElement(location);
                locationField.setText(""); // Clear the input field
            } else {
                showMessage("City already exists in the list!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        savedCitiesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String selectedCity = savedCitiesList.getSelectedValue();

                if (e.getClickCount() == 1) { // Single-click detected
                    if (selectedCity != null) {
                        WeatherData weatherData = fetchWeatherData.fetchWeather(selectedCity);
                        if (weatherData != null) {
                            updateWeatherDisplay(weatherData, locationDisplay, temperatureDisplay, conditionDisplay, humidityDisplay);
                        } else {
                            showMessage("Error fetching weather for " + selectedCity, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (e.getClickCount() == 2) { // Double-click detected
                    if (selectedCity != null) {
                        openCityDetails(selectedCity);
                    }
                }
            }
        });

        // Adding Components to Frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(weatherPanel, BorderLayout.CENTER);
        frame.add(cityListPanel, BorderLayout.EAST);

        frame.setVisible(true);

        // Load initial cities into the list
        refreshCityList();
    }

    private void refreshCityList() {
        cityListModel.clear();
        manageCitiesInteractor.getCities().forEach(cityListModel::addElement);
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    private void updateWeatherDisplay(WeatherData weatherData, JLabel locationDisplay, JLabel temperatureDisplay,
                                      JLabel conditionDisplay, JLabel humidityDisplay) {
        locationDisplay.setText("Location: " + weatherData.getLocation());
        temperatureDisplay.setText("Temperature: " + weatherData.getTemperature() + "°C");
        conditionDisplay.setText("Condition: " + weatherData.getCondition());
        humidityDisplay.setText("Humidity: " + weatherData.getHumidity() + "%");
    }



    private void openCityDetails(String cityName) {
        GetDetailsView getDetailsView = new GetDetailsView(cityName);
        getDetailsView.setVisible(true);
    }
}
