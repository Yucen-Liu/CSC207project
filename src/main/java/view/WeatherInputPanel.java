package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WeatherInputPanel extends JPanel {
    private final JTextField searchField; // Input field for city search

    public WeatherInputPanel(ActionListener searchActionListener, ActionListener saveActionListener) {
        setLayout(new FlowLayout());

        // Add input field and buttons
        JLabel searchLabel = new JLabel("Enter City:");
        searchField = new JTextField(15); // Initialize input field
        JButton searchButton = new JButton("Search");
        JButton saveButton = new JButton("Save");

        // Attach action listeners
        searchButton.addActionListener(searchActionListener);
        saveButton.addActionListener(saveActionListener);

        // Add components to the panel
        add(searchLabel);
        add(searchField);
        add(searchButton);
        add(saveButton);
    }

    /**
     * Returns the text entered in the search field.
     *
     * @return the search query entered by the user
     */
    public String getSearchQuery() {
        return searchField.getText().trim(); // Retrieve and trim the input
    }
}
