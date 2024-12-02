
package app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        WeatherAppBuilder appBuilder = new WeatherAppBuilder();
        JFrame application = appBuilder
//                .addSearchCityView()
                .addGetDetailsView()
//                .addWeatherAppView()
                .addSearchCityView()
                .addGetForecastView()
//                .addManageSortView()
                .addNearbyCitiesView()

                .addGetDetailsUseCase()
//                .addWeatherAppUseCase()
                .addGetForecastUseCase()
//                .addManageSortUseCase()
                .addNearbyCitiesUseCase()
//                .addSearchCityUseCase()
                .build();

        application.pack();
        application.setVisible(true);
    }
}
