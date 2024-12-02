package app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        WeatherAppBuilder appBuilder = new WeatherAppBuilder();
        JFrame application = appBuilder
//                .addSearchCityView()
                .addGetDetailsView()
//                .addWeatherAppView()
                .addGetForecastView()
//                .addManageSortView()
//                .addSearchCityView()
                .addNearbyCitiesView()

                .addGetDetailsUseCase()
//                .addWeatherAppUseCase()
                .addGetForecastUseCase()
//                .addManageSortUseCase()
//                .addSearchCityUseCase()
                .addNearbyCitiesUseCase()
                .build();

        application.pack();
        application.setVisible(true);
    }
}
