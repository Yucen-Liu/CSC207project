package use_case.get_forecast;

import data_access.ForecastWeatherInfoObject;
import entity.*;
import use_case.login.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class GetForecastInteractorTest {

    @Test
    void successTest() throws IOException {
        List<String> savedCityNames = new ArrayList<>();
        savedCityNames.add("Osaka");
        savedCityNames.add("Tokyo");
        savedCityNames.add("London");
        GetForecastInputData inputData = new GetForecastInputData("Osaka", savedCityNames);
        GetForecastDataAccessInterface weatherForecast = new ForecastWeatherInfoObject(new ForecastCityFactory());

        // This creates a successPresenter that tests whether the test case is as we expect.
        GetForecastOutputBoundary successPresenter = new GetForecastOutputBoundary() {
            @Override
            public void prepareSuccessView(GetForecastOutputData response) {
                assertEquals("Osaka", response.getCityName());
                assertEquals(savedCityNames, response.getSavedCityNames());
                assertEquals("10.05", response.getTemperatureSixHoursLater());
                assertEquals("few clouds", response.getConditionThreeHoursLater());
                assertEquals("73", response.getHumidityThreeHoursLater());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToGetDetailsView() {
            }
        };

        GetForecastInputBoundary interactor = new GetForecastInteractor(weatherForecast, successPresenter);
        interactor.execute(inputData);
    }

}
