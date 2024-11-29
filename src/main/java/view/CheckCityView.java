package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.check_city.CheckCityController;
import interface_adapter.check_city.CheckCityState;
import interface_adapter.check_city.CheckCityViewModel;

/**
 * The View for the CheckCity Use Case.
 */
public class CheckCityView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "check city";
    private final CheckCityViewModel checkCityViewModel;

    private final JTextField citynameInputField = new JTextField(15);
    private final JTextField citycheckResultField = new JTextField(15);
    private CheckCityController checkCityController;

    private final JButton login;
    private final JButton signup;

    public CheckCityView(CheckCityViewModel checkCityViewModel) {
        this.checkCityViewModel = checkCityViewModel;
        checkCityViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(CheckCityViewModel.APPLICATION_TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel cityCheck = new LabelTextPanel(
                new JLabel(CheckCityViewModel.CHECK_CITY_LABEL), citynameInputField);

        final JPanel buttons = new JPanel();
        signup = new JButton(CheckCityViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signup);
        login = new JButton(CheckCityViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(login);

        login.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        checkCityController.switchToLoginView();
                    }
                }
        );

        signup.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        checkCityController.switchToSignupView();
                    }
                }
        );

        citynameInputField.getDocument().addDocumentListener(new DocumentListener() {
            private void documentListenerHelper() {
                final CheckCityState currentState = checkCityViewModel.getState();
                currentState.setCityname(citynameInputField.getText());
                checkCityViewModel.setState(currentState);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(cityCheck);
        this.add(buttons);
        this.add(citycheckResultField);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final CheckCityState state = (CheckCityState) evt.getNewValue();
        setFields(state);
        citynameInputField.setText(state.getCitynameResult());
    }

    private void setFields(CheckCityState state) {
        citynameInputField.setText(state.getCityname());
    }

    public String getViewName() {
        return viewName;
    }

    public void setCheckCityController(CheckCityController checkCityController) {
        this.checkCityController = checkCityController;
    }
}

