package view;

import data_access.FavoriteCityStorageImpl;
import entity.City;
import entity.CityFactory;
import entity.CityStorage;
import interface_adapter.get_forecast.GetForecastController;
import interface_adapter.get_forecast.GetForecastViewModel;
import interface_adapter.manage_cities.ManageCitiesController;
import use_case.manage_cities.FavoriteCitiesInteractor;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherAppView extends JPanel {
    private final CityStorage cityStorage; // Dependency injected
    private final CityFactory cityFactory; // Dependency injected
    private final GetForecastController getForecastController;

    public WeatherAppView(CityStorage cityStorage, CityFactory cityFactory, GetForecastController getForecastController) {
        this.cityStorage = cityStorage;
        this.cityFactory = cityFactory;
        this.getForecastController = getForecastController;

        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel locationLabel = new JLabel("Enter Location:");
        JTextField locationField = new JTextField(15);
        JButton getForecastButton = new JButton("Get Forecast");
        JButton saveCityButton = new JButton("Save City");

        inputPanel.add(locationLabel);
        inputPanel.add(locationField);
        inputPanel.add(getForecastButton);
        inputPanel.add(saveCityButton);

        // Forecast Display Panel
        JPanel forecastPanel = new JPanel(new GridLayout(4, 1));
        JLabel locationDisplay = new JLabel("Location: ");
        JLabel temperatureDisplay = new JLabel("Temperature (Next 3 Hours): ");
        JLabel conditionDisplay = new JLabel("Condition: ");
        JLabel humidityDisplay = new JLabel("Humidity: ");

        forecastPanel.add(locationDisplay);
        forecastPanel.add(temperatureDisplay);
        forecastPanel.add(conditionDisplay);
        forecastPanel.add(humidityDisplay);

        // Saved Cities List
        DefaultListModel<String> listModel = getCityListModel(cityStorage.getCities());
        JList<String> savedCitiesList = new JList<>(listModel);
        savedCitiesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel cityListPanel = new JPanel(new BorderLayout());
        JButton manageCitiesButton = new JButton("Manage Cities");

        manageCitiesButton.addActionListener(e -> manageCities());

        cityListPanel.add(manageCitiesButton, BorderLayout.NORTH);
        cityListPanel.add(new JScrollPane(savedCitiesList), BorderLayout.CENTER);

        // Adding Components to Main Panel
        add(inputPanel, BorderLayout.NORTH);
        add(cityListPanel, BorderLayout.WEST);
        add(forecastPanel, BorderLayout.CENTER);

        // Get Forecast Button Action
        getForecastButton.addActionListener(e -> {
            String location = locationField.getText().trim();
            if (location.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a location.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Prepare saved city names
            List<String> savedCityNames = cityStorage.getCities()
                    .stream()
                    .map(City::getLocation)
                    .collect(Collectors.toList());

            // Use the controller to execute the forecast use case
            getForecastController.execute(location, savedCityNames);

            // Update display based on the ViewModel
            GetForecastViewModel viewModel = getForecastController.getViewModel();
            updateForecastDisplay(viewModel, locationDisplay, temperatureDisplay, conditionDisplay, humidityDisplay);
        });

    }

    /**
     * Converts a List<City> to a DefaultListModel<String>.
     * @param cities the list of cities to convert.
     * @return a DefaultListModel containing the city names.
     */
    private DefaultListModel<String> getCityListModel(List<City> cities) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (City city : cities) {
            model.addElement(city.getLocation());
        }
        return model;
    }

    private void updateForecastDisplay(GetForecastViewModel viewModel, JLabel locationDisplay, JLabel temperatureDisplay,
                                       JLabel conditionDisplay, JLabel humidityDisplay) {
        locationDisplay.setText("Location: " + viewModel.getCityName());
        temperatureDisplay.setText("Temperature (Next 3 Hours): " + viewModel.getTemperatureThreeHoursLater() + "°C");
        conditionDisplay.setText("Condition: " + viewModel.getConditionThreeHoursLater());
        humidityDisplay.setText("Humidity: " + viewModel.getHumidityThreeHoursLater() + "%");
    }


    private void manageCities() {
        // Link to the ManageCityView window
        ManageCitiesController controller = new ManageCitiesController(new FavoriteCitiesInteractor(new FavoriteCityStorageImpl()));
        ManageCityView manageCityView = new ManageCityView(controller);
        manageCityView.setVisible(true); // Show the ManageCityView window
    }
}
