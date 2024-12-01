package view;

import javax.swing.*;
import java.awt.*;

public class GetDetailsView extends JFrame {
    private final String cityName;

    public GetDetailsView(String cityName) {
        this.cityName = cityName;
        setTitle("City Details - " + cityName);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeUI();
    }

    private void initializeUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel cityLabel = new JLabel("City: " + cityName);
        JLabel temperatureLabel = new JLabel("Temperature: Loading...");
        JLabel conditionLabel = new JLabel("Condition: Loading...");
        JLabel humidityLabel = new JLabel("Humidity: Loading...");

        panel.add(cityLabel);
        panel.add(temperatureLabel);
        panel.add(conditionLabel);
        panel.add(humidityLabel);

        // Dummy weather data; replace with real data fetching in the future
        SwingUtilities.invokeLater(() -> {
            temperatureLabel.setText("Temperature: 22°C");
            conditionLabel.setText("Condition: Sunny");
            humidityLabel.setText("Humidity: 60%");
        });

        getContentPane().add(panel);
    }
}
