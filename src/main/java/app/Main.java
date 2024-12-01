package app;

import javax.swing.JFrame;

/**
 * The Main class of the weather application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the weather application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final WeatherAppBuilder appBuilder = new WeatherAppBuilder();
        // add the Logout Use Case to the app using the appBuilder
        final JFrame application = appBuilder
//                  .addCheckCityView()
                  .addGetForecastView()
//                  .addCheckCityUseCase()
                  .addGetForecastUseCase()
                  .build();

        application.pack();
        application.setVisible(true);
    }

}

