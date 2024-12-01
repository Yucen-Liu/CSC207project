package view;

import data_access.FavoriteCityStorageImpl;
import interface_adapter.manage_cities.ManageCitiesController;
import org.weatherapp.MessageBox;
import org.weatherapp.WeatherData;
import org.weatherapp.WeatherService;
import use_case.manage_cities.FavoriteCitiesInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WeatherAppView extends JFrame {
    private final WeatherService weatherService;
    private final WeatherInputPanel inputPanel;
    private final WeatherDisplayPanel displayPanel;
    private final SavedCitiesPanel citiesPanel;

    public WeatherAppView(WeatherService weatherService) {
        super("Weather App");
        this.weatherService = weatherService;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        inputPanel = new WeatherInputPanel(this::handleGetWeather, this::handleSaveCity);
        displayPanel = new WeatherDisplayPanel();
        citiesPanel = new SavedCitiesPanel(this::manageCities, new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String selectedCity = citiesPanel.getSelectedCity();
                    if (selectedCity != null) {
                        openCityDetails(selectedCity);
                    }
                }
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(citiesPanel, BorderLayout.WEST);
        add(displayPanel, BorderLayout.CENTER);
    }

    private void handleGetWeather(ActionEvent e) {
        String location = inputPanel.getLocationInput();
        if (location.isEmpty()) {
            MessageBox.showWarningNoLoc(this);
            return;
        }

        WeatherData weatherData = weatherService.getCurrentWeather(location);
        if (weatherData != null) {
            displayPanel.updateWeatherDisplay(
                    weatherData.getLocation(),
                    weatherData.getTemperature() + "°C",
                    weatherData.getCondition(),
                    weatherData.getHumidity() + "%"
            );
            inputPanel.clearLocationField();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid city! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void handleSaveCity(ActionEvent e) {
        String location = inputPanel.getLocationInput(); // Use getLocationInput() here
        if (location.isEmpty()) {
            MessageBox.showWarningNoLoc(this);
            return;
        }
        citiesPanel.addCity(location);
        inputPanel.clearLocationField();
    }


    private void manageCities(ActionEvent e) {
        JFrame frame = new JFrame("Manage Favorite Cities");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
//        frame.add(new ManageCityView(CONTROLLER HERE));
        frame.setVisible(true);
    }



    private void openCityDetails(String cityName) {
        GetDetailsView detailsView = new GetDetailsView(cityName);
        detailsView.setVisible(true);
    }
}
