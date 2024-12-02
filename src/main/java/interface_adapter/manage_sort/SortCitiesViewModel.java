package interface_adapter.manage_sort;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the SortCities feature.
 */
public class SortCitiesViewModel extends ViewModel<SortCitiesState> {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public SortCitiesViewModel() {
        super("sort cities");
        setState(new SortCitiesState());
    }

    public void firePropertyChanged(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
