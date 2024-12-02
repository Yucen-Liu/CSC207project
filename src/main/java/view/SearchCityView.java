package view;

import data_access.FavoriteCityStorageImpl;
import entity.City;
import entity.CityFactory;
import entity.CityStorage;
import interface_adapter.get_forecast.GetForecastController;
import interface_adapter.get_forecast.GetForecastViewModel;
import interface_adapter.manage_cities.ManageCitiesController;
import interface_adapter.search_city.SearchCityController;
import interface_adapter.search_city.SearchCityViewModel;
import use_case.manage_cities.FavoriteCitiesInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.stream.Collectors;

public class SearchCityView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "search city";
    private final SearchCityViewModel searchCityViewModel;

    private final JTextField locationField = new JTextField(15);

    private SearchCityController searchCityController;

    public SearchCityView(SearchCityViewModel searchCityViewModel) {
        this.searchCityViewModel = searchCityViewModel;
        this.searchCityViewModel.addPropertyChangeListener(this);

        setLayout(new BorderLayout());

        final JLabel title = new JLabel(searchCityViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel locationLabel = new JLabel("Enter Location:");
        JButton getWeatherButton = new JButton("Get Weather");
        JButton saveCityButton = new JButton("Save City");

        inputPanel.add(locationLabel);
        inputPanel.add(locationField);
        inputPanel.add(getWeatherButton);
        inputPanel.add(saveCityButton);

        // Forecast Display Panel
        JPanel forecastPanel = new JPanel(new GridLayout(4, 1));
        JLabel locationDisplay = new JLabel("Location: ");
        JLabel temperatureDisplay = new JLabel("Temperature: ");
        JLabel conditionDisplay = new JLabel("Condition: ");
        JLabel humidityDisplay = new JLabel("Humidity: ");

        forecastPanel.add(locationDisplay);
        forecastPanel.add(temperatureDisplay);
        forecastPanel.add(conditionDisplay);
        forecastPanel.add(humidityDisplay);

        // Saved Cities List
        DefaultListModel<String> listModel = getCityListModel(searchCityViewModel.getSavedCityNames());
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



        // Get Weather Button Action
        getWeatherButton.addActionListener(e -> {
            String location = locationField.getText().trim();
            if (location.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a location.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // Validate the city name
//            if (checkCityController.isValid(location)) {
//                checkCityController.execute(location);
//            }
//            else {
//
//                JOptionPane.showMessageDialog(this, "Invalid city! Please enter a valid city.", "Validation Error", JOptionPane.ERROR_MESSAGE);
//            }
            searchCityController.execute(location, searchCityViewModel.getSavedCityNames());

            // Prepare saved city names
            List<String> savedCityNames = searchCityViewModel.getSavedCityNames();

            // Use the controller to execute the forecast use case
            searchCityController.execute(location, savedCityNames);

            // Update display based on the ViewModel
            SearchCityViewModel viewModel = searchCityController.getSearchCityViewModel();
            updateForecastDisplay(viewModel, locationDisplay, temperatureDisplay, conditionDisplay, humidityDisplay);
        });

        // Save City Button Action
        saveCityButton.addActionListener(e -> {
            String location = locationField.getText();
            if (location.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a location.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
//            else if (checkCityController.isValid(location)) {
//                // Save city list function here
//            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid city! Please enter a valid city.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

    private DefaultListModel<String> getCityListModel(List<String> cityNames) {
        DefaultListModel<String> model = new DefaultListModel<>();
        if(cityNames != null) {
            for (String cityName : cityNames) {
                model.addElement(cityName);
            }
        }
        return model;
    }

    private void updateForecastDisplay(SearchCityViewModel viewModel, JLabel locationDisplay, JLabel temperatureDisplay,
                                       JLabel conditionDisplay, JLabel humidityDisplay) {
        locationDisplay.setText("Location: " + viewModel.getLocation());
        temperatureDisplay.setText("Temperature: " + viewModel.getTemperature() + "°C");
        conditionDisplay.setText("Condition: " + viewModel.getCondition());
        humidityDisplay.setText("Humidity: " + viewModel.getHumidity() + "%");
    }

    private void manageCities() {
        // Link to the ManageCityView window
        ManageCitiesController controller = new ManageCitiesController(new FavoriteCitiesInteractor(new FavoriteCityStorageImpl()));
        ManageCityView manageCityView = new ManageCityView(controller);
        manageCityView.setVisible(true); // Show the ManageCityView window

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
