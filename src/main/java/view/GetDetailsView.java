package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import interface_adapter.get_details.GetDetailsController;
import interface_adapter.get_details.GetDetailsState;
import interface_adapter.get_details.GetDetailsViewModel;
import interface_adapter.get_forecast.GetForecastController;
import interface_adapter.get_forecast.GetForecastState;


public class GetDetailsView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "get details";
    private final GetDetailsViewModel getDetailsViewModel;

    private final JLabel temperatureLabel = new JLabel("Temperature:");
    private final JLabel humidityLabel = new JLabel("Humidity:");
    private final JLabel pressureLabel = new JLabel("Pressure:");
    private final JLabel visibilityLabel = new JLabel("Visibility:");
    private final JLabel conditionLabel = new JLabel("Condition:");
    private final JLabel tempMinLabel = new JLabel("Minimum Temperature:");
    private final JLabel tempMaxLabel = new JLabel("Maximum Temperature:");


    private final JLabel temperature = new JLabel("");
    private final JLabel condition = new JLabel("");
    private final JLabel humidity = new JLabel("");

    private final JLabel tempMax = new JLabel("");
    private final JLabel tempMin = new JLabel("");
    private final JLabel pressure = new JLabel("");
    private final JLabel visibility = new JLabel("");

    private final JLabel cityNameLabel = new JLabel("");

    private final JButton back;
    private final JButton getForecast;
    private final JButton getNearbyCities;
    private final JButton get;

    private GetDetailsController getDetailsController;
    private GetForecastController getForecastController;
    private DefaultTableModel tableModel;

    public GetDetailsView(GetDetailsViewModel getDetailsViewModel) {
        this.getDetailsViewModel = getDetailsViewModel;
        this.getDetailsViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Detailed Weather Information for:");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel citySelected = new JPanel(new FlowLayout(FlowLayout.LEFT));
        citySelected.setAlignmentX(Component.CENTER_ALIGNMENT);
        citySelected.add(title);
        citySelected.add(cityNameLabel);

        String[][] data ={
                {temperatureLabel.getText(), temperature.getText()},
                {conditionLabel.getText(), condition.getText()},
                {humidityLabel.getText(), humidity.getText()},
                {tempMinLabel.getText(), tempMin.getText()},
                {tempMaxLabel.getText(), tempMax.getText()},
                {pressureLabel.getText(), pressure.getText()},
                {visibilityLabel.getText(), visibility.getText()}
        };
        String[] columnNames = {"Info","Data"};

        tableModel = new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(tableModel);

        final JPanel buttons = new JPanel();
        get = new JButton("Get Details");
        buttons.add(get);
        get.addActionListener(this);
        back = new JButton("Close");
        buttons.add(back);
        getForecast = new JButton("Get forecast");
        buttons.add(getForecast);
        getNearbyCities = new JButton("Get nearby cities");
        buttons.add(getNearbyCities);

        final GetDetailsState currentState = getDetailsViewModel.getState();

//        getForecast.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        getDetailsController.switchToGetForecastView();
//                    }
//                }
//        );

        getForecast.addActionListener(e -> {
            String cityName = currentState.getCityName();
            getDetailsController.switchToGetForecastView(cityName);
        });

        getNearbyCities.addActionListener(e -> {
            String cityName = currentState.getCityName();
            getDetailsController.switchToGetNearbyCitiesView(cityName);
        });

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        getDetailsController.switchToSearchCityView();
                    }
                }
        );

//        get.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        final GetDetailsState currentState = getDetailsViewModel.getState();
//                        getDetailsController.execute(
//                                currentState.getCityName(), currentState.getSavedCityNames()
//                        );
//                        setFields(currentState);
//                    }
//                }
//        );

        get.addActionListener(e -> {
            getDetailsController.execute(
                    currentState.getCityName(), currentState.getSavedCityNames()
            );
            setFields(currentState);
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(citySelected);
        add(table);
        add(buttons);
    }

    /**
     * React to a button click that results in evt.
     *
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GetDetailsState state = (GetDetailsState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(GetDetailsState state) {
        cityNameLabel.setText(state.getCityName());
        tableModel.setValueAt(Double.toString(state.getTemperature()), 0, 1);
        tableModel.setValueAt(state.getCondition(), 1, 1);
        tableModel.setValueAt(String.valueOf(state.getHumidity()), 2, 1);
        tableModel.setValueAt(Double.toString(state.getTemp_max()), 3, 1);
        tableModel.setValueAt(Double.toString(state.getTemp_min()), 4, 1);
        tableModel.setValueAt(String.valueOf(state.getPressure()), 5, 1);
        tableModel.setValueAt(String.valueOf(state.getVisibility()), 6, 1);
    }

    public String getViewName() {
        return viewName;
    }

    public void setGetDetailsController(GetDetailsController getDetailsController) {
        this.getDetailsController = getDetailsController;
    }
}


