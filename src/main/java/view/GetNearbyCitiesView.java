package view;

import interface_adapter.nearby_cities.NearbyCitiesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetNearbyCitiesView {//extends JPanel implements ActionListener, PropertyChangeListener {
//    private final String viewName = "nearby cities";
//
//    private final NearbyCitiesViewModel nearbyCitiesViewModel;
//
//    private final JTextField cityNameField = new JTextField(15);
//
//
//    private final JButton get;
//    private final JButton back;
//
//    public GetNearbyCitiesView(NearbyCitiesViewModel nearbyCitiesViewModel) {
//
//        this.nearbyCitiesViewModel = nearbyCitiesViewModel;
//        this.getHistoryViewModel.addPropertyChangeListener(this);
//
//        final JLabel title = new JLabel(getHistoryViewModel.GET_HISTORY_TITLE_LABEL);
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        final LabelTextPanel cityName = new LabelTextPanel(
//                new JLabel(getHistoryViewModel.CITY_NAME_LABEL), cityNameField);
//
//        String[][] data = {{getHistoryViewModel.TEMPERATURE_LABEL,temperatureThreeHourAgoField.getText(),
//                temperatureSixHourAgoField.getText(), temperatureNineHourAgoField.getText()},
//                {getHistoryViewModel.CONDITION_LABEL,conditionThreeHourAgoField.getText(),
//                        conditionSixHourAgoField.getText(), conditionNineHourAgoField.getText()},
//                {getHistoryViewModel.HUMIDITY_LABEL,humidityThreeHourAgoField.getText(),
//                        humiditySixHourAgoField.getText(), humidityNineHourAgoField.getText()}};
//
//        String[] columnNames = {getHistoryViewModel.INFO_LABEL, getHistoryViewModel.THREE_HOURS_AGO_LABEL,
//                getHistoryViewModel.SIX_HOURS_AGO_LABEL, getHistoryViewModel.NINE_HOURS_AGO_LABEL};
//
//        final JTable table = new JTable(data, columnNames);
//        JScrollPane scrollPane = new JScrollPane(table);
//
//
//        final JPanel buttons = new JPanel();
//        get = new JButton(getHistoryViewModel.GET_HISTORY_BUTTON_LABEL);
//        buttons.add(get);
//        back = new JButton(getHistoryViewModel.BACK_BUTTON_LABEL);
//        buttons.add(back);
//
//        get.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        final GetHistoryState currentState = getHistoryViewModel.getState();
//                        getHistoryController.execute(
//                                currentState.getCityName(), currentState.getSavedCityNames()
//                        );
//                    }
//                }
//        );
//
//        back.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        getHistoryController.switchGetDetailsView();
//                    }
//                }
//        );
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.add(title);
//        this.add(cityName);
//        this.add(buttons);
//        this.add(scrollPane);
//    }
//
//    /**
//     * React to a button click that results in evt.
//     * @param evt the ActionEvent to react to
//     */
//    public void actionPerformed(ActionEvent evt) {
//        System.out.println("Click " + evt.getActionCommand());
//    }
//
//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        final GetHistoryState state = (GetHistoryState) evt.getNewValue();
//        setFields(state);
//    }
//
//    private void setFields(GetHistoryState state) {
//        cityNameField.setText(state.getCityName());
//        temperatureThreeHourAgoField.setText(state.getTemperatureThreeHoursAgo());
//        conditionThreeHourAgoField.setText(state.getConditionThreeHoursAgo());
//        humidityThreeHourAgoField.setText(state.getHumidityThreeHoursAgo());
//
//        temperatureSixHourAgoField.setText(state.getTemperatureSixHoursAgo());
//        conditionSixHourAgoField.setText(state.getConditionSixHoursAgo());
//        humiditySixHourAgoField.setText(state.getHumiditySixHoursAgo());
//
//        temperatureNineHourAgoField.setText(state.getTemperatureNineHoursAgo());
//        conditionNineHourAgoField.setText(state.getConditionNineHoursAgo());
//        humidityNineHourAgoField.setText(state.getHumidityNineHoursAgo());
//    }
//
//    public String getViewName() {
//        return viewName;
//    }
//
//    public void setLoginController(GetHistoryController getHistoryController) {
//        this.getHistoryController = getHistoryController;
//    }
}
