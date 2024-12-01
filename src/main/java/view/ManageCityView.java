package view;

import interface_adapter.manage_cities.ManageCitiesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ManageCityView extends JPanel {
    private final ManageCitiesController controller;
    private final JTextField cityInputField = new JTextField(15);
    private final DefaultListModel<String> listModel = new DefaultListModel<>();

    public ManageCityView(ManageCitiesController controller) {
        this.controller = controller;

        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");

        inputPanel.add(cityInputField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // List Panel
        JList<String> favoriteCitiesList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(favoriteCitiesList);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Load favorite cities for the default user
        loadFavoriteCities("user1");

        // Button Listeners
        addButton.addActionListener((ActionEvent e) -> {
            String city = cityInputField.getText();
            if (!city.isEmpty()) {
                controller.addCityToFavorites("user1", city);
                loadFavoriteCities("user1");
                cityInputField.setText("");
            }
        });

        removeButton.addActionListener((ActionEvent e) -> {
            String selectedCity = favoriteCitiesList.getSelectedValue();
            if (selectedCity != null) {
                controller.removeCityFromFavorites("user1", selectedCity);
                loadFavoriteCities("user1");
            }
        });
    }

    private void loadFavoriteCities(String userId) {
        listModel.clear();
        List<String> favorites = controller.getUserFavorites(userId);
        for (String city : favorites) {
            listModel.addElement(city);
        }
    }
}
