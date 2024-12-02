package entity;

import javax.swing.*;

// Utility class for showing warning and information messages
public class MessageBox {

    // Shows an error message dialog
    public static void showError(String message, JFrame parent) {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Shows an information message dialog
    public static void showInfo(String message, JFrame parent) {
        JOptionPane.showMessageDialog(parent, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    // Shows a warning message dialog
    public static void showWarningNoLoc(JFrame parent) {
        JOptionPane.showMessageDialog(parent, "Please enter a Valid location!", "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
