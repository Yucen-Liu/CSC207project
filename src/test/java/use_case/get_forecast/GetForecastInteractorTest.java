package use_case.get_forecast;


public class GetForecastInteractorTest {
//
//    @Test
//    void successTest() throws IOException {
//        List<String> savedCityNames = new ArrayList<>();
//        savedCityNames.add("Osaka");
//        savedCityNames.add("Tokyo");
//        savedCityNames.add("London");
//        GetForecastInputData inputData = new GetForecastInputData("Osaka", savedCityNames);
//        GetForecastDataAccessInterface weatherForecast = new ForecastWeatherInfoObject(new ForecastCityFactory());
//
//        // This creates a successPresenter that tests whether the test case is as we expect.
//        // The test successfully passed at 6:39 PM Toronto time on November 30, 2024,
//        // demonstrating that the implementation of the get_forecast use case is successful.
//        // However, due to the real-time nature of API data,
//        // we cannot guarantee that the same test will pass in the future.
//        GetForecastOutputBoundary successPresenter = new GetForecastOutputBoundary() {
//            @Override
//            public void prepareSuccessView(GetForecastOutputData response) {
//                assertEquals("Osaka", response.getCityName());
//                assertEquals(savedCityNames, response.getSavedCityNames());
//
//                assertEquals("10.05", response.getTemperatureThreeHoursLater());
//                assertEquals("few clouds", response.getConditionThreeHoursLater());
//                assertEquals("63", response.getHumidityThreeHoursLater());
//
//                assertEquals("12.66", response.getTemperatureSixHoursLater());
//                assertEquals("few clouds", response.getConditionSixHoursLater());
//                assertEquals("53", response.getHumiditySixHoursLater());
//
//                assertEquals("14.28", response.getTemperatureNineHoursLater());
//                assertEquals("scattered clouds", response.getConditionNineHoursLater());
//                assertEquals("48", response.getHumidityNineHoursLater());
//            }
//
//            @Override
//            public void prepareFailView(String error) {
//                fail("Use case failure is unexpected.");
//            }
//
//            @Override
//            public void switchToGetDetailsView() {
//            }
//        };
//        GetForecastInputBoundary interactor = new GetForecastInteractor(weatherForecast, successPresenter);
//        interactor.execute(inputData);
//    }

}
