package interface_adapter.manage_sort;

import entity.CommonCity;
import interface_adapter.ViewModel;
import interface_adapter.get_forecast.GetForecastState;

import java.util.List;

/**
 * ViewModel for the SortCities feature.
 */
public class SortCitiesViewModel extends ViewModel<SortCitiesState> {

    public SortCitiesViewModel(){
        super("sort cities");
        setState(new SortCitiesState());
    }

//    /**
//     * Returns the sorted cities as a formatted string for the view.
//     *
//     * @return A formatted string representing the sorted cities.
//     */
//    public String getFormattedCities() {
//        List<CommonCity> sortedCities = state.getSortedCities();
//        if (sortedCities == null || sortedCities.isEmpty()) {
//            return "No cities available.";
//        }
//
//        StringBuilder formattedCities = new StringBuilder();
//        for (CommonCity city : sortedCities) {
//            formattedCities.append(String.format(
//                    "%s: Temperature = %.1f°C, Condition = %s, Humidity = %d%%\n",
//                    city.getLocation(),
//                    city.getTemperature(),
//                    city.getCondition(),
//                    city.getHumidity()
//            ));
//        }
//        return formattedCities.toString();
//    }
}
