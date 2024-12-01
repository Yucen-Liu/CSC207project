package view;

import javax.swing.*;
import java.awt.*;

public class WeatherDisplayPanel extends JPanel {
    private final JLabel locationDisplay;
    private final JLabel temperatureDisplay;
    private final JLabel conditionDisplay;
    private final JLabel humidityDisplay;

    public WeatherDisplayPanel() {
        setLayout(new GridLayout(4, 1));

        locationDisplay = new JLabel("Location: ");
        temperatureDisplay = new JLabel("Temperature: ");
        conditionDisplay = new JLabel("Condition: ");
        humidityDisplay = new JLabel("Humidity: ");

        add(locationDisplay);
        add(temperatureDisplay);
        add(conditionDisplay);
        add(humidityDisplay);
    }

    public void updateWeatherDisplay(String location, String temperature, String condition, String humidity) {
        locationDisplay.setText("Location: " + location);
        temperatureDisplay.setText("Temperature: " + temperature);
        conditionDisplay.setText("Condition: " + condition);
        humidityDisplay.setText("Humidity: " + humidity);
    }
}
