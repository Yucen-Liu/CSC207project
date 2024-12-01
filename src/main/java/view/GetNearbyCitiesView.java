package view;

import interface_adapter.nearby_cities.NearbyCitiesController;
import interface_adapter.nearby_cities.NearbyCitiesState;
import interface_adapter.nearby_cities.NearbyCitiesViewModel;

import javax.swing.*;
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

    private final JButton back;

    public GetNearbyCitiesView(NearbyCitiesViewModel nearbyCitiesViewModel) {
        this.nearbyCitiesViewModel = nearbyCitiesViewModel;
        nearbyCitiesViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(nearbyCitiesViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Rounding for temperature
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        int numberNearbyCities = nearbyCitiesViewModel.getNearbyCityNames().size();

//        String[][] data = {{getHistoryViewModel.TEMPERATURE_LABEL,temperatureThreeHourAgoField.getText(),
//                temperatureSixHourAgoField.getText(), temperatureNineHourAgoField.getText()},
//                {getHistoryViewModel.CONDITION_LABEL,conditionThreeHourAgoField.getText(),
//                        conditionSixHourAgoField.getText(), conditionNineHourAgoField.getText()},
//                {getHistoryViewModel.HUMIDITY_LABEL,humidityThreeHourAgoField.getText(),
//                        humiditySixHourAgoField.getText(), humidityNineHourAgoField.getText()}};
//
//        String[] columnNames = {getHistoryViewModel.INFO_LABEL, getHistoryViewModel.THREE_HOURS_AGO_LABEL,
//                getHistoryViewModel.SIX_HOURS_AGO_LABEL, getHistoryViewModel.NINE_HOURS_AGO_LABEL};

        String[][] data = new String[numberNearbyCities][4];
        for (int i = 0; i < numberNearbyCities; i++) {
            data[i][0] = nearbyCitiesViewModel.getNearbyCityNames().get(i);
            data[i][1] = df.format(nearbyCitiesViewModel.getNearbyCitiesTemperature().get(i));
            data[i][2] = nearbyCitiesViewModel.getNearbyCitiesCondition().get(i);
            data[i][3] = String.valueOf(nearbyCitiesViewModel.getNearbyCitiesHumidity().get(i));
        }

        String [] columnNames = {nearbyCitiesViewModel.CITY_NAMES_LABEL, nearbyCitiesViewModel.TEMPERATURE_LABEL,
                nearbyCitiesViewModel.CONDITION_LABEL, nearbyCitiesViewModel.HUMIDITY_LABEL};

        final JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);


        final JPanel buttons = new JPanel();
        back = new JButton(nearbyCitiesViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        nearbyCitiesController.switchGetDetailsView();
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
        this.add(scrollPane);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
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
    }

    public String getViewName() {
        return viewName;
    }

    public void setNearbyCitiesController(NearbyCitiesController controller) {
        this.nearbyCitiesController = controller;
    }
}
