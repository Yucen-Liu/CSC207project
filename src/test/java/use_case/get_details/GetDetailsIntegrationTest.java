package use_case.get_details;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.get_details.*;

import entity.DetailedCity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetDetailsIntegrationTest {

    private GetDetailsInteractor interactor;
    private String resultCityName;
    private double resultTemperature;

    @BeforeEach
    public void setUp() {
        GetDetailsDataAccessInterface dataAccess = cityName -> new DetailedCity(
                cityName, 25.0, "Sunny", 65, 20.0, 30.0, 1013, 10000);

        GetDetailsOutputBoundary outputBoundary = new GetDetailsOutputBoundary() {
            @Override
            public void switchToSearchCityView() {}

            @Override
            public void switchToGetNearbyCitiesView() {}

            @Override
            public void switchToGetForecastView() {}

            @Override
            public void prepareSuccessView(GetDetailsOutputData outputData) {
                resultCityName = outputData.getCityName();
                resultTemperature = outputData.getTemperature();
            }

            @Override
            public void prepareFailView(String errorMessage) {}
        };

        interactor = new GetDetailsInteractor(dataAccess, outputBoundary);
    }

    @Test
    public void testExecute() {
        // Arrange
        GetDetailsInputData inputData = new GetDetailsInputData("CityA", List.of("CityB", "CityC"));

        // Act
        interactor.execute(inputData);

        // Assert
        assertEquals("CityA", resultCityName);
        assertEquals(25.0, resultTemperature);
    }
}
