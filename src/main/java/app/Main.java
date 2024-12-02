
package app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        WeatherAppBuilder appBuilder = new WeatherAppBuilder();
        JFrame application = appBuilder
                .addSearchCityView()
                .addGetDetailsView()
                .addGetForecastView()
//                .addManageSortView()
                .addNearbyCitiesView()
                .addSearchCityView()

                .addGetDetailsUseCase()
//                .addWeatherAppUseCase()
                .addGetForecastUseCase()
//                .addManageSortUseCase()
                .addNearbyCitiesUseCase()
                .addSearchCityUseCase()


                .build();

        application.pack();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setVisible(true);
    }
}
