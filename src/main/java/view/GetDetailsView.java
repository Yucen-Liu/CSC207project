package view;

import org.json.JSONObject;
import org.weatherapp.WeatherData;
import org.weatherapp.WeatherService;

import javax.swing.*;
import java.awt.*;

public class GetDetailsView extends JFrame {
    private final String cityName;
    private final WeatherService weatherService;

    public GetDetailsView(String cityName) {
        this.cityName = cityName;
        this.weatherService = new WeatherService();

        // Frame configuration
        setTitle("Details for " + cityName);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new BorderLayout());

        // Fetch detailed weather data for the city
        WeatherData weatherData = weatherService.getCurrentWeather(cityName);

        if (weatherData == null) {
            JOptionPane.showMessageDialog(this, "Unable to fetch weather details for " + cityName,
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create and populate the details panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(6, 1, 5, 5)); // 6 rows, 1 column

        JLabel cityLabel = new JLabel("City: " + weatherData.getLocation());
        JLabel temperatureLabel = new JLabel("Temperature: " + weatherData.getTemperature() + "°C");
        JLabel conditionLabel = new JLabel("Condition: " + weatherData.getCondition());
        JLabel humidityLabel = new JLabel("Humidity: " + weatherData.getHumidity() + "%");

        // Optional fields for additional data from the API
        JLabel windSpeedLabel = new JLabel();
        JLabel pressureLabel = new JLabel();

        // Add labels to the details panel
        detailsPanel.add(cityLabel);
        detailsPanel.add(temperatureLabel);
        detailsPanel.add(conditionLabel);
        detailsPanel.add(humidityLabel);
        detailsPanel.add(windSpeedLabel);
        detailsPanel.add(pressureLabel);

        // Add a Close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose()); // Close the window when clicked

        // Add components to the frame
        add(detailsPanel, BorderLayout.CENTER);
        add(closeButton, BorderLayout.SOUTH);
    }
}
