package view;

import interface_adapter.get_details.GetDetailsController;
import interface_adapter.get_details.GetDetailsViewModel;
import interface_adapter.get_forecast.GetForecastViewModel;
import interface_adapter.nearby_cities.NearbyCitiesViewModel;
import org.weatherapp.WeatherData;
import org.weatherapp.WeatherService;
import view.GetForecastView;
import view.GetNearbyCitiesView;

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
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new BorderLayout());

        // Button panel at the top
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton getForecastButton = new JButton("Get Forecast");
        JButton getNearbyCitiesButton = new JButton("Get Nearby Cities");

        buttonPanel.add(getForecastButton);
        buttonPanel.add(getNearbyCitiesButton);

        add(buttonPanel, BorderLayout.NORTH);

        // Add ActionListeners for buttons
        getForecastButton.addActionListener(e -> openGetForecastView());
        getNearbyCitiesButton.addActionListener(e -> openGetNearbyCitiesView());

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

        // Add components to the frame
        add(detailsPanel, BorderLayout.CENTER);

        // Close button at the bottom
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);
    }

    private void openGetForecastView() {
        // Initialize and show GetForecastView
        GetForecastView forecastView = new GetForecastView(new GetForecastViewModel());
        JFrame forecastFrame = new JFrame("Weather Forecast for " + cityName);
        forecastFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        forecastFrame.setSize(600, 400);
        forecastFrame.add(forecastView);
        forecastFrame.setVisible(true);
    }

    private void openGetNearbyCitiesView() {
        // Initialize and show GetNearbyCitiesView
        GetNearbyCitiesView nearbyCitiesView = new GetNearbyCitiesView(new NearbyCitiesViewModel());
        JFrame nearbyCitiesFrame = new JFrame("Nearby Cities for " + cityName);
        nearbyCitiesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nearbyCitiesFrame.setSize(600, 400);
        nearbyCitiesFrame.add(nearbyCitiesView);
        nearbyCitiesFrame.setVisible(true);
    }
}
//private final String viewName = "get details;
//private final GetDetailsViewModel getDetailsViewModel;
//
//private final JTextField temperature = new JTextField(15);
//private final JTextField condition= new JTextField(15);
//private final JTextField humidity = new JTextField(15);
//
//private final JTextField tempMax = new JTextField(15);
//private final JTextField tempMin = new JTextField(15);
//private final JTextField pressure = new JTextField(15);
//
//private final JTextField visibility = new JTextField(15);
//
//private final JLabel cityNameLabel = new JLabel("");
//
//private final JButton close;
//private final JButton getForecast;
//private final JButton getNearbyCities;
//
//private GetDetailsController getDetailsController;
//
//public GetDetailsView(GetDetailsViewModel getDetailsViewModel, String cityName) {
//    this.getDetailsViewModel = getDetailsViewModel;
//    this.getDetailsViewModel.addPropertyChangeListener(this);
//
//    final JLabel title = new JLabel("Detailed Information");
//    title.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//    final JPanel temp