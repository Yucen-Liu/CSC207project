package view;

import interface_adapter.get_forecast.GetForecastController;
import interface_adapter.get_forecast.GetForecastState;
import interface_adapter.get_forecast.GetForecastViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetForecastView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "get forecast";
    private final GetForecastViewModel getForecastViewModel;

    private final JTextField temperatureThreeHourLaterField = new JTextField(15);
    private final JTextField conditionThreeHourLaterField = new JTextField(15);
    private final JTextField humidityThreeHourLaterField = new JTextField(15);

    private final JTextField temperatureSixHourLaterField = new JTextField(15);
    private final JTextField conditionSixHourLaterField = new JTextField(15);
    private final JTextField humiditySixHourLaterField = new JTextField(15);

    private final JTextField temperatureNineHourLaterField = new JTextField(15);
    private final JTextField conditionNineHourLaterField = new JTextField(15);
    private final JTextField humidityNineHourLaterField = new JTextField(15);

    private final JLabel cityNameLabel = new JLabel("");


    private final JButton get;
    private final JButton back;
    private GetForecastController getForecastController;

    public GetForecastView(GetForecastViewModel getForecastViewModel) {

        this.getForecastViewModel = getForecastViewModel;
        this.getForecastViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(getForecastViewModel.GET_FORECAST_TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel citySelected = new JPanel(new FlowLayout(FlowLayout.LEFT));
        citySelected.setAlignmentX(Component.CENTER_ALIGNMENT);
        citySelected.add(new JLabel(getForecastViewModel.CITY_NAME_LABEL));
        citySelected.add(cityNameLabel);

        String[][] data = {{getForecastViewModel.TEMPERATURE_LABEL, temperatureThreeHourLaterField.getText(),
        temperatureSixHourLaterField.getText(), temperatureNineHourLaterField.getText()},
                {getForecastViewModel.CONDITION_LABEL, conditionThreeHourLaterField.getText(),
                        conditionSixHourLaterField.getText(), conditionNineHourLaterField.getText()},
                {getForecastViewModel.HUMIDITY_LABEL, humidityThreeHourLaterField.getText(),
                        humiditySixHourLaterField.getText(), humidityNineHourLaterField.getText()}};

        String[] columnNames = {getForecastViewModel.INFO_LABEL, getForecastViewModel.THREE_HOURS_AGO_LABEL,
                getForecastViewModel.SIX_HOURS_AGO_LABEL, getForecastViewModel.NINE_HOURS_AGO_LABEL};

        final JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);


        final JPanel buttons = new JPanel();
        get = new JButton(getForecastViewModel.GET_FORECAST_BUTTON_LABEL);
        buttons.add(get);
        back = new JButton(getForecastViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        get.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        final GetForecastState currentState = getForecastViewModel.getState();
                        getForecastController.execute(
                                currentState.getCityName(), currentState.getSavedCityNames()
                        );
                    }
                }
                );

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        getForecastController.switchToGetDetailsView();
                    }
                }
                );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(citySelected);
        this.add(buttons);
        this.add(scrollPane);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GetForecastState state = (GetForecastState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(GetForecastState state) {
        cityNameLabel.setText(state.getCityName());
        temperatureThreeHourLaterField.setText(state.getTemperatureThreeHoursLater());
        conditionThreeHourLaterField.setText(state.getConditionThreeHoursLater());
        humidityThreeHourLaterField.setText(state.getHumidityThreeHoursLater());

        temperatureSixHourLaterField.setText(state.getTemperatureSixHoursLater());
        conditionSixHourLaterField.setText(state.getConditionSixHoursLater());
        humiditySixHourLaterField.setText(state.getHumiditySixHoursLater());

        temperatureNineHourLaterField.setText(state.getTemperatureNineHoursLater());
        conditionNineHourLaterField.setText(state.getConditionNineHoursLater());
        humidityNineHourLaterField.setText(state.getHumidityNineHoursLater());
    }

    public String getViewName() {
        return viewName;
    }

    public void setGetForecastController(GetForecastController getForecastController) {
        this.getForecastController = getForecastController;
    }


}
