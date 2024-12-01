package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WeatherInputPanel extends JPanel {
    private final JTextField locationField;
    private final JButton getWeatherButton;
    private final JButton saveCityButton;

    public WeatherInputPanel(ActionListener getWeatherListener, ActionListener saveCityListener) {
        setLayout(new FlowLayout());

        JLabel locationLabel = new JLabel("Enter Location:");
        locationField = new JTextField(15);
        getWeatherButton = new JButton("Get Weather");
        saveCityButton = new JButton("Save City");

        add(locationLabel);
        add(locationField);
        add(getWeatherButton);
        add(saveCityButton);

        getWeatherButton.addActionListener(getWeatherListener);
        saveCityButton.addActionListener(saveCityListener);
    }

    /**
     * Gets the text from the location input field.
     * @return the entered location as a string
     */
    public String getLocationInput() {
        return locationField.getText();
    }

    /**
     * Clears the text from the location input field.
     */
    public void clearLocationField() {
        locationField.setText("");
    }
}
