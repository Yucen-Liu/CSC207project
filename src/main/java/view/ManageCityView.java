package view;

import interface_adapter.manage_cities.ManageCitiesController;

import javax.swing.*;
import java.awt.*;

public class ManageCityView extends JFrame {
    private final ManageCitiesController controller;
    private final DefaultListModel<String> cityListModel;
    private final JList<String> cityList;

    public ManageCityView(ManageCitiesController controller) {
        this.controller = controller;
        this.cityListModel = new DefaultListModel<>();
        this.cityList = new JList<>(cityListModel);

        setTitle("Manage Cities");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeUI();
    }

    private void initializeUI() {
        JPanel panel = new JPanel(new BorderLayout());

        // Add the list of cities
        JScrollPane scrollPane = new JScrollPane(cityList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton removeCityButton = new JButton("Remove City");
        buttonPanel.add(removeCityButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        removeCityButton.addActionListener(e -> {
            String selectedCity = cityList.getSelectedValue();
            if (selectedCity != null) {
                controller.removeCity(selectedCity);
                cityListModel.removeElement(selectedCity);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a city to remove!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        getContentPane().add(panel);

        // Load cities into the list
        loadCities();
    }

    private void loadCities() {
        cityListModel.clear();
        controller.getCities().forEach(cityListModel::addElement);
    }

}
