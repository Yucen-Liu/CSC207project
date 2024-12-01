package view;

import interface_adapter.manage_sort.SortCitiesController;
import interface_adapter.manage_sort.SortCitiesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View for sorting cities using JFrame.
 */
public class SortCitiesView extends JFrame {

    private final SortCitiesController controller;
    private final SortCitiesViewModel viewModel;
    private final JTextArea displayArea;

    public SortCitiesView(SortCitiesController controller, SortCitiesViewModel viewModel) {
        this.controller = controller;
        this.viewModel = viewModel;

        // 设置 JFrame 的基本属性
        setTitle("Sort Cities 的界面");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 添加按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // 添加 "Sort by Temperature" 按钮
        JButton temperatureButton = new JButton("Temperature");
        temperatureButton.setBackground(Color.GREEN);
        temperatureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleSortRequest("temperature");
                updateDisplay();
            }
        });
        buttonPanel.add(temperatureButton);

        // 添加 "Sort by Condition" 按钮
        JButton conditionButton = new JButton("Condition");
        conditionButton.setBackground(Color.GREEN);
        conditionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleSortRequest("condition");
                updateDisplay();
            }
        });
        buttonPanel.add(conditionButton);

        // 添加 "Sort by Humidity" 按钮
        JButton humidityButton = new JButton("Humidity");
        humidityButton.setBackground(Color.GREEN);
        humidityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleSortRequest("humidity");
                updateDisplay();
            }
        });
        buttonPanel.add(humidityButton);

        add(buttonPanel, BorderLayout.NORTH);

        // 添加显示区域
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
    }

    /**
     * Updates the display area with the sorted city list.
     */
    private void updateDisplay() {
        displayArea.setText(viewModel.getFormattedCities());
    }

    /**
     * Launches the JFrame for user interaction.
     */
    public void display() {
        setVisible(true);
    }
}
