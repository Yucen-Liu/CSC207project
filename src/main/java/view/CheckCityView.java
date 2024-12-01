package view;

import interface_adapter.check_city.CheckCityViewModel;
import interface_adapter.check_city.CheckCityController;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CheckCityView extends JPanel {
    private final JTextField cityNameInputField = new JTextField(15);
    private final JButton check = new JButton("Check");
    private final JLabel resultLabel = new JLabel();
    private CheckCityController checkCityController;

    public CheckCityView(CheckCityViewModel viewModel) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter City:"));
        inputPanel.add(cityNameInputField);
        inputPanel.add(check);

        add(inputPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);

        viewModel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("isValid".equals(evt.getPropertyName())) {
                    boolean isValid = (boolean) evt.getNewValue();
                    resultLabel.setText(isValid ? "City is valid!" : "City is invalid!");
                }
            }
        });

        check.addActionListener(e -> {
            if (checkCityController != null) {
                String cityName = cityNameInputField.getText();
                checkCityController.execute(cityName);
            }
        });
    }

    public void setCheckCityController(CheckCityController controller) {
        this.checkCityController = controller;
    }

    public String getViewName() {
        return "check city";
    }
}
