package view;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;

public class ViewManager {
    private final JPanel cardPanel;
    private final CardLayout cardLayout;
    private final ViewManagerModel viewManagerModel;

    public ViewManager(JPanel cardPanel, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
    }

    public void switchTo(String viewName) {
        cardLayout.show(cardPanel, viewName);
        viewManagerModel.setState(viewName);
    }

    public String getCurrentView() {
        return viewManagerModel.getState();
    }

    public void firePropertyChanged() {
        viewManagerModel.firePropertyChanged();
    }
}
