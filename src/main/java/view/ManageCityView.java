package view;

import interface_adapter.manage_cities.ManageCitiesController;
import use_case.manage_cities.FavoriteCitiesInteractor;
import data_access.FavoriteCityStorageImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManageCityView extends JFrame {

    private final ManageCitiesController manageCitiesController;
    private final JTextField cityInputField;
    private final JButton addButton;
    private final JButton removeButton;
    private final JList<String> favoriteCitiesList;
    private final DefaultListModel<String> listModel;

    public ManageCityView(ManageCitiesController manageCitiesController) {
        this.manageCitiesController = manageCitiesController;

        setTitle("Manage Favorite Cities");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel for adding/removing cities
        JPanel inputPanel = new JPanel();
        cityInputField = new JTextField(15);
        addButton = new JButton("Add to Favorites");
        removeButton = new JButton("Remove from Favorites");
        inputPanel.add(cityInputField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // List to display favorite cities
        listModel = new DefaultListModel<>();
        favoriteCitiesList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(favoriteCitiesList);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Load favorite cities for demonstration (assuming userId is "user1")
        loadFavoriteCities("user1");

        // Add ActionListener to Add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cityName = cityInputField.getText();
                if (!cityName.isEmpty()) {
                    manageCitiesController.addCityToFavorites("user1", cityName);
                    loadFavoriteCities("user1");
                    cityInputField.setText("");
                }
            }
        });

        // Add ActionListener to Remove button
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cityName = favoriteCitiesList.getSelectedValue();
                if (cityName != null) {
                    manageCitiesController.removeCityFromFavorites("user1", cityName);
                    loadFavoriteCities("user1");
                }
            }
        });
    }

    // Load favorite cities from controller and update the list
    private void loadFavoriteCities(String userId) {
        listModel.clear();
        List<String> favoriteCities = manageCitiesController.getUserFavorites(userId);
        for (String city : favoriteCities) {
            listModel.addElement(city);
        }
    }

    public static void main(String[] args) {
        // Assuming we have an implementation for FavoriteCityStorage
        ManageCitiesController controller = new ManageCitiesController(new FavoriteCitiesInteractor(new FavoriteCityStorageImpl()));
        ManageCityView view = new ManageCityView(controller);
        view.setVisible(true);
    }
}
