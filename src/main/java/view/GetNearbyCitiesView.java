package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetNearbyCitiesView extends JPanel {
    private final String cityName;
    private final DefaultListModel<String> cityListModel;
    private final JList<String> cityList;

    public GetNearbyCitiesView(String cityName) {
        this.cityName = cityName;

        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Nearby Cities for " + cityName, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        // List to display nearby cities
        cityListModel = new DefaultListModel<>();
        cityList = new JList<>(cityListModel);
        JScrollPane scrollPane = new JScrollPane(cityList);
        add(scrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton backButton = new JButton("Back");
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load initial nearby cities
        loadNearbyCities();


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame (assumes the panel is in a JFrame)
                SwingUtilities.getWindowAncestor(GetNearbyCitiesView.this).dispose();
            }
        });
    }

    private void loadNearbyCities() {
        // Clear the current list
        cityListModel.clear();

        // Simulate fetching nearby cities from a service
        try {
            List<String> nearbyCities = fetchNearbyCities(cityName);

            if (nearbyCities.isEmpty()) {
                cityListModel.addElement("No nearby cities found.");
            } else {
                for (String city : nearbyCities) {
                    cityListModel.addElement(city);
                }
            }
        } catch (Exception e) {
            cityListModel.addElement("Error fetching nearby cities.");
        }
    }

    private List<String> fetchNearbyCities(String cityName) {
        // Simulate a backend call to fetch nearby cities
        // Replace this with the actual API or data service call
        return List.of("City A", "City B", "City C", "City D");
    }
}
