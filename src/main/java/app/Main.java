package app;

import javax.swing.JFrame;

/**
 * The Main class of the weather application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final WeatherAppBuilder appBuilder = new WeatherAppBuilder();
        // add the Logout Use Case to the app using the appBuilder
        final JFrame application = appBuilder
//                .addLoginView()
//                .addSignupView()
//                .addLoggedInView()
                  .addCheckCityView()
//                .addSignupUseCase()
//                .addLoginUseCase()
//                .addChangePasswordUseCase()
//                .addLogoutUseCase()
                  .addCheckCityUseCase()
                  .build();

        application.pack();
        application.setVisible(true);
    }

}

