package app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        WeatherAppBuilder appBuilder = new WeatherAppBuilder();
        JFrame application = appBuilder
//                .addCheckCityView()
                .addWeatherAppView()
                .addGetForecastView()
                .addManageCityView()
                .build();


        application.setVisible(true);
    }
}
