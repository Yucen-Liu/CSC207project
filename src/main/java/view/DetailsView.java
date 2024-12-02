package view;

import interface_adapter.get_forecast.GetForecastViewModel;
import interface_adapter.nearby_cities.NearbyCitiesViewModel;
import org.weatherapp.WeatherData;
import org.weatherapp.WeatherService;

import javax.swing.*;
import java.awt.*;

public class DetailsView extends JFrame {
    private final String cityName;
    private final WeatherService weatherService;

    public DetailsView(String cityName) {
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

//package view;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//import interface_adapter.get_details.GetDetailsController;
//import interface_adapter.get_details.GetDetailsState;
//import interface_adapter.get_details.GetDetailsViewModel;
//
//
//public class GetDetailsView extends JPanel implements ActionListener, PropertyChangeListener {
//    private final String viewName = "get details";
//    private final GetDetailsViewModel getDetailsViewModel;
//
//    private final JLabel temperatureLabel = new JLabel("Temperature:");
//    private final JLabel humidityLabel = new JLabel("Humidity:");
//    private final JLabel pressureLabel = new JLabel("Pressure:");
//    private final JLabel ConditionLabel = new JLabel("Condition:");
//    private final JLabel visibilityLabel = new JLabel("Visibility:");
//    private final JLabel conditionLabel = new JLabel("Condition:");
//    private final JLabel tempMinLabel = new JLabel("Minimum Temperature:");
//    private final JLabel tempMaxLabel = new JLabel("Maximum Temperature:");
//
//
//    private final JLabel temperature = new JLabel("");
//    private final JLabel condition = new JLabel("");
//    private final JLabel humidity = new JLabel("");
//
//    private final JLabel tempMax = new JLabel("");
//    private final JLabel tempMin = new JLabel("");
//    private final JLabel pressure = new JLabel("");
//    private final JLabel visibility = new JLabel("");
//
//    private final JLabel cityNameLabel = new JLabel("");
//
//    private final JButton back;
//    private final JButton getForecast;
//    private final JButton getNearbyCities;
//    private final JButton get;
//
//    private GetDetailsController getDetailsController;
//
//    public GetDetailsView(GetDetailsViewModel getDetailsViewModel) {
//        this.getDetailsViewModel = getDetailsViewModel;
//        this.getDetailsViewModel.addPropertyChangeListener(this);
//
//        final JLabel title = new JLabel("Detailed Weather Information");
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        final JPanel citySelected = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        citySelected.setAlignmentX(Component.CENTER_ALIGNMENT);
//        citySelected.add(title);
//        citySelected.add(cityNameLabel);
//
//        String[][] data ={{temperatureLabel.getText(), temperature.getText()},
//                {conditionLabel.getText(), condition.getText()},
//                {humidityLabel.getText(), humidity.getText()},
//                {tempMinLabel.getText(), tempMin.getText()},
//                {tempMaxLabel.getText(), tempMax.getText()},
//                {pressureLabel.getText(), pressure.getText()},
//                {visibilityLabel.getText(), visibility.getText()}};
//
//        String[] columnNames = {"Info","Data"};
//        final JTable table = new JTable(data, columnNames);
//
//        final JPanel buttons = new JPanel();
//        get = new JButton("Get Details");
//        get.addActionListener(this);
//        back = new JButton("Close");
//        buttons.add(back);
//        getForecast = new JButton("Get forecast");
//        buttons.add(getForecast);
//        getNearbyCities = new JButton("Get nearby cities");
//        buttons.add(getNearbyCities);
//
//        getForecast.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        getDetailsController.switchToGetForecastView();
//                    }
//                }
//        );
//
//        getNearbyCities.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        getDetailsController.switchToGetNearbyCitiesView();
//                    }
//                }
//        );
//
//        back.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        getDetailsController.switchToSearchCityView();
//                    }
//                }
//        );
//
//        get.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        final GetDetailsState currentState = getDetailsViewModel.getState();
//                        getDetailsController.execute(
//                                currentState.getCityName(), currentState.getSavedCityNames()
//                        );
//                    }
//                }
//        );
//
//
//        this.add(citySelected);
//        this.add(buttons);
//        this.add(table);
//    }
//
//    /**
//     * React to a button click that results in evt.
//     *
//     * @param evt the ActionEvent to react to
//     */
//    public void actionPerformed(ActionEvent evt) {
//        System.out.println("Click " + evt.getActionCommand());
//    }
//
//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        final GetDetailsState state = (GetDetailsState) evt.getNewValue();
//        setFields(state);
//    }
//
//    private void setFields(GetDetailsState state) {
//        cityNameLabel.setText(state.getCityName());
//        temperature.setText(Double.toString(state.getTemperature()));
//        condition.setText(state.getCondition());
//        humidity.setText(String.valueOf((state.getHumidity())));
//
//        tempMax.setText(Double.toString(state.getTemp_max()));
//        tempMin.setText(Double.toString(state.getTemp_min()));
//        pressure.setText(String.valueOf(state.getPressure()));
//        visibility.setText(String.valueOf(state.getVisibility()));
//
//    }
//
//    public String getViewName() {
//        return viewName;
//    }
//
//    public void setGetDetailsController(GetDetailsController getDetailsController) {
//        this.getDetailsController = getDetailsController;
//    }
//}