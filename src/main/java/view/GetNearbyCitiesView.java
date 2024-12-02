package view;

import interface_adapter.get_details.GetDetailsState;
import interface_adapter.nearby_cities.NearbyCitiesController;
import interface_adapter.nearby_cities.NearbyCitiesState;
import interface_adapter.nearby_cities.NearbyCitiesViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class GetNearbyCitiesView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "nearby cities";

    private final NearbyCitiesViewModel nearbyCitiesViewModel;
    private final JLabel cityNameField = new JLabel("");

    private NearbyCitiesController nearbyCitiesController;
    private DefaultTableModel nearbyCitiesTableModel;

    private final JButton get;
    private final JButton back;

    public GetNearbyCitiesView(NearbyCitiesViewModel nearbyCitiesViewModel) {
        this.nearbyCitiesViewModel = nearbyCitiesViewModel;
        this.nearbyCitiesViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(nearbyCitiesViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Rounding for temperature
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        int numberNearbyCities = nearbyCitiesViewModel.getNearbyCityNames().size();

        String[][] data = new String[numberNearbyCities][4];
        for (int i = 0; i < numberNearbyCities; i++) {
            data[i][0] = nearbyCitiesViewModel.getNearbyCityNames().get(i);
            data[i][1] = df.format(nearbyCitiesViewModel.getNearbyCitiesTemperature().get(i));
            data[i][2] = nearbyCitiesViewModel.getNearbyCitiesCondition().get(i);
            data[i][3] = String.valueOf(nearbyCitiesViewModel.getNearbyCitiesHumidity().get(i));
        }

        String [] columnNames = {nearbyCitiesViewModel.CITY_NAMES_LABEL, nearbyCitiesViewModel.TEMPERATURE_LABEL,
                nearbyCitiesViewModel.CONDITION_LABEL, nearbyCitiesViewModel.HUMIDITY_LABEL};

        nearbyCitiesTableModel = new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(nearbyCitiesTableModel);

        final JPanel buttons = new JPanel();
        get = new JButton("Get Nearby Weather");
        buttons.add(get);
        get.addActionListener(this);
        back = new JButton(nearbyCitiesViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        nearbyCitiesController.switchGetDetailsView();
                    }
                }
        );

        get.addActionListener(e -> {
            final NearbyCitiesState currentState = nearbyCitiesViewModel.getState();
            nearbyCitiesController.execute(
                    currentState.getCityName(), currentState.getNearbyCityNames()
            );
            setFields(currentState);
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
        this.add(table);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final NearbyCitiesState state = (NearbyCitiesState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(NearbyCitiesState state) {
        cityNameField.setText(state.getCityName());
        nearbyCitiesTableModel.setRowCount(0);

        // Rounding for temperature
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        int numberNearbyCities = state.getNearbyCityNames().size();
        for (int i = 0; i < numberNearbyCities; i++) {
            String[] rowData = {state.getNearbyCityNames().get(i),
                    df.format(state.getNearbyCityTemperatures().get(i)) + " °C",
                    state.getNearbyCityConditions().get(i),
                    String.valueOf(state.getNearbyCityHumidities().get(i)) + "%"};
            nearbyCitiesTableModel.addRow(rowData);
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setNearbyCitiesController(NearbyCitiesController controller) {
        this.nearbyCitiesController = controller;
    }
}
