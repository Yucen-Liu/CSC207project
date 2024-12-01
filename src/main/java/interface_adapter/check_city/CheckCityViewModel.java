package interface_adapter.check_city;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CheckCityViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String cityName;
    private boolean isValid;

    /**
     * Adds a listener to observe state changes.
     *
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Removes a previously added listener.
     *
     * @param listener the listener to remove
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    /**
     * Gets the name of the city.
     *
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the name of the city and notifies listeners.
     *
     * @param cityName the new city name
     */
    public void setCityName(String cityName) {
        String oldCityName = this.cityName;
        this.cityName = cityName;
        support.firePropertyChange("cityName", oldCityName, cityName);
    }

    /**
     * Returns whether the city is valid.
     *
     * @return true if the city is valid, false otherwise
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Sets whether the city is valid and notifies listeners.
     *
     * @param isValid the new validity status
     */
    public void setValid(boolean isValid) {
        boolean oldIsValid = this.isValid;
        this.isValid = isValid;
        support.firePropertyChange("isValid", oldIsValid, isValid);
    }
}
