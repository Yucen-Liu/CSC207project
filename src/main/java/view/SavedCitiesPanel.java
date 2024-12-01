package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SavedCitiesPanel extends JPanel {
    private final DefaultListModel<String> cityListModel;
    private final JList<String> cityList;

    public SavedCitiesPanel(ActionListener manageCitiesListener, MouseAdapter citySelectionListener) {
        setLayout(new BorderLayout());

        cityListModel = new DefaultListModel<>();
        cityList = new JList<>(cityListModel);
        cityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cityList.addMouseListener(citySelectionListener);

        JButton manageCitiesButton = new JButton("Manage Cities");
        manageCitiesButton.addActionListener(manageCitiesListener);

        add(manageCitiesButton, BorderLayout.NORTH);
        add(new JScrollPane(cityList), BorderLayout.CENTER);
    }

    public void addCity(String city) {
        if (!cityListModel.contains(city)) {
            cityListModel.addElement(city);
        }
    }

    public String getSelectedCity() {
        return cityList.getSelectedValue();
    }
}
