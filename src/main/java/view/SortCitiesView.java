package view;

import entity.CommonCity;
import interface_adapter.manage_sort.SortCitiesController;
import interface_adapter.manage_sort.SortCitiesState;
import interface_adapter.manage_sort.SortCitiesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * View for sorting cities using JFrame.
 */
public class SortCitiesView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "sort cities";
    private final SortCitiesViewModel sortCitiesViewModel;
    private SortCitiesController sortCitiesController;

    private final JScrollPane panel;

    private final JButton temperatureButton = new JButton("Temperature");
    private final JButton conditionButton = new JButton("Condition");
    private final JButton humidityButton = new JButton("Humidity");
    private final JButton backButton = new JButton("Back");



    public SortCitiesView(SortCitiesViewModel sortCitiesViewModel) {
        this.sortCitiesViewModel = sortCitiesViewModel;
        this.sortCitiesViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Sort Cities");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(20, 1)); // 20 rows, 1 column
        for (int i = 1; i <= 20; i++) {
            panel.add(new JLabel(""));
        }

        // Wrap the panel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(panel);
        this.panel = scrollPane;
//        // 设置 JFrame 的基本属性
//        setTitle("Sort Cities 的界面");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());

        // 添加按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // 添加 "Sort by Temperature" 按钮
        temperatureButton.setBackground(Color.GREEN);
        temperatureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final SortCitiesState currentState = sortCitiesViewModel.getState();
                sortCitiesController.execute("temperature",currentState.getCityNames()); // !!!!!!!! important here: here we input the controller with criterion with温度，湿度或者是状况
//                updateDisplay();
            }
        });
        buttonPanel.add(temperatureButton);

        // 添加 "Sort by Condition" 按钮
        conditionButton.setBackground(Color.GREEN);
        conditionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final SortCitiesState currentState = sortCitiesViewModel.getState();
                sortCitiesController.execute("condition",currentState.getCityNames());
//                updateDisplay();
            }
        });
        buttonPanel.add(conditionButton);

        // 添加 "Sort by Humidity" 按钮
        humidityButton.setBackground(Color.GREEN);
        humidityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final SortCitiesState currentState = sortCitiesViewModel.getState();
                sortCitiesController.execute("humidity",currentState.getCityNames());
//                updateDisplay();
            }
        });

        backButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        sortCitiesController.switchToSearchCityView();
                    }
                }
        );
        buttonPanel.add(humidityButton);

//        add(buttonPanel, BorderLayout.NORTH);

        // 添加显示区域
//        displayArea = new JTextArea();
//        displayArea.setEditable(false);
//        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttonPanel);
        this.add(scrollPane);
        this.add(backButton);
    }

    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("sortedCities".equals(evt.getPropertyName())) {
            System.out.println("View: Detected property change for sortedCities.");
            SortCitiesState state = (SortCitiesState) evt.getNewValue();
            setFields(state);
        }
    }

    private void setFields(SortCitiesState state) {
        JPanel cityListPanel = new JPanel();
        cityListPanel.setLayout(new GridLayout(0, 1));

        for (CommonCity city : state.getSortedCities()) {
            cityListPanel.add(new JLabel(String.format(
                    "%s: Temperature = %.1f°C, Condition = %s, Humidity = %d%%",
                    city.getLocation(), city.getTemperature(), city.getCondition(), city.getHumidity()
            )));
        }

        System.out.println("View: Updating panel with sorted cities: " + state.getSortedCities());

        panel.setViewportView(cityListPanel);
        panel.revalidate();
        panel.repaint();
    }



    public String getViewName() {
        return viewName;
    }

    public void setSortCitiesController(SortCitiesController sortCitiesController) {
        this.sortCitiesController = sortCitiesController;}

//    /**
//     * Updates the display area with the sorted city list.
//     */
//    private void updateDisplay() {
//        displayArea.setText(viewModel.getFormattedCities());
//    }
//
//        /**
//     * Returns the sorted cities as a formatted string for the view.
//     *
//     * @return A formatted string representing the sorted cities.
//     */
//
//    }
//    /**
//     * Returns the sorted cities as a formatted string for the view.
//     *
//     * @return A formatted string representing the sorted cities.
//     */
    public String getFormattedCities(String cityNmae, SortCitiesState state) {
        List<CommonCity> sortedCities = state.getSortedCities();
        if (sortedCities == null || sortedCities.isEmpty()) {
            return "No cities available.";
        }

        StringBuilder formattedCities = new StringBuilder();
        for (CommonCity city : sortedCities) {
            formattedCities.append(String.format(
                    "%s: Temperature = %.1f°C, Condition = %s, Humidity = %d%%\n",
                    city.getLocation(),
                    city.getTemperature(),
                    city.getCondition(),
                    city.getHumidity()
            ));
        }
        return formattedCities.toString();
    }
//
//    /**
//     * Launches the JFrame for user interaction.
//     */
//    public void display() {
//        setVisible(true);
//    }
    }
