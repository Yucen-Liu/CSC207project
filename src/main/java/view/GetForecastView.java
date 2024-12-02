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

    private final JLabel temperatureThreeHourLaterLabel = new JLabel("");
    private final JLabel conditionThreeHourLaterLabel = new JLabel("");
    private final JLabel humidityThreeHourLaterLabel = new JLabel("");

    private final JLabel temperatureSixHourLaterLabel = new JLabel("");
    private final JLabel conditionSixHourLaterLabel = new JLabel("");
    private final JLabel humiditySixHourLaterLabel = new JLabel("");

    private final JLabel temperatureNineHourLaterLabel = new JLabel("");
    private final JLabel conditionNineHourLaterLabel = new JLabel("");
    private final JLabel humidityNineHourLaterLabel = new JLabel("");

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

        String[][] data = {{getForecastViewModel.TEMPERATURE_LABEL, temperatureThreeHourLaterLabel.getText(),
        temperatureSixHourLaterLabel.getText(), temperatureNineHourLaterLabel.getText()},
                {getForecastViewModel.CONDITION_LABEL, conditionThreeHourLaterLabel.getText(),
                        conditionSixHourLaterLabel.getText(), conditionNineHourLaterLabel.getText()},
                {getForecastViewModel.HUMIDITY_LABEL, humidityThreeHourLaterLabel.getText(),
                        humiditySixHourLaterLabel.getText(), humidityNineHourLaterLabel.getText()}};

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
        temperatureThreeHourLaterLabel.setText(state.getTemperatureThreeHoursLater());
        conditionThreeHourLaterLabel.setText(state.getConditionThreeHoursLater());
        humidityThreeHourLaterLabel.setText(state.getHumidityThreeHoursLater());

        temperatureSixHourLaterLabel.setText(state.getTemperatureSixHoursLater());
        conditionSixHourLaterLabel.setText(state.getConditionSixHoursLater());
        humiditySixHourLaterLabel.setText(state.getHumiditySixHoursLater());

        temperatureNineHourLaterLabel.setText(state.getTemperatureNineHoursLater());
        conditionNineHourLaterLabel.setText(state.getConditionNineHoursLater());
        humidityNineHourLaterLabel.setText(state.getHumidityNineHoursLater());
    }

    public String getViewName() {
        return viewName;
    }

    public void setGetForecastController(GetForecastController getForecastController) {
        this.getForecastController = getForecastController;
    }


}
