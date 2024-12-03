package use_case.get_forecast;
import entity.ForecastCity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

class GetForecastInteractorTest {
    @Mock
    private GetForecastDataAccessInterface mockGetForecastDataAccessInterface;
    @Mock
    private GetForecastOutputBoundary mockGetForecastOutputBoundary;
    private GetForecastInteractor getForecastInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getForecastInteractor = new GetForecastInteractor(mockGetForecastDataAccessInterface, mockGetForecastOutputBoundary);
    }

    @Test
    void successSwitchToGetDetailsTest() {
        getForecastInteractor.switchToGetDetailsView();
        verify(mockGetForecastOutputBoundary).switchToGetDetailsView();
    }

    @Test
    void successTest() {
        String cityName = "Osaka";
        List<List<String>> forecastDetails = new ArrayList<>();
        forecastDetails.add(List.of("13", "Sunny", "89"));
        forecastDetails.add(List.of("14", "Cloudy", "90"));
        forecastDetails.add(List.of("12", "Snowy", "101"));
        ForecastCity mockForecast = new ForecastCity(cityName, 11, "Windy", 90, forecastDetails);
        when(mockGetForecastDataAccessInterface.getWeatherForecast(cityName, 4)).thenReturn(mockForecast);
        GetForecastInputData getForecastInputData = new GetForecastInputData(cityName, new ArrayList<>());
        getForecastInteractor.execute(getForecastInputData);
        verify(mockGetForecastOutputBoundary).prepareSuccessView(any(GetForecastOutputData.class));
    }

    @Test
    void failureCityNameEmptyTest() {
        GetForecastInputData inputData = new GetForecastInputData("", new ArrayList<>());
        getForecastInteractor.execute(inputData);
        verify(mockGetForecastOutputBoundary).prepareFailView("Unable to fetch the name of the selected city.");
    }

    @Test
    void failureForecastCityNullPrepareFailViewTest() {
        String cityName = "Shanghai";
        when(mockGetForecastDataAccessInterface.getWeatherForecast(cityName, 4)).thenReturn(null);
        GetForecastInputData inputData = new GetForecastInputData(cityName, new ArrayList<>());
        getForecastInteractor.execute(inputData);
        verify(mockGetForecastOutputBoundary).prepareFailView(
                "Unable to fetch the weather forecast information for the selected city: Cannot invoke \"entity.ForecastCity.getForecast()\" because \"forecastCity\" is null"
        );
    }

    @Test
    void failureCityNamePrepareFailViewTest() {
        GetForecastInputData inputData = new GetForecastInputData(null, new ArrayList<>());
        getForecastInteractor.execute(inputData);
        verify(mockGetForecastOutputBoundary).prepareFailView("Unable to fetch the name of the selected city.");}

    @Test
    void failurePrepareDataAccessFailViewTest() {
        String cityName = "Tokyo";
        String errorMessage = "Unable to fetch the weather forecast information for the selected city: Data access error";
        when(mockGetForecastDataAccessInterface.getWeatherForecast(cityName, 4)).thenThrow(new RuntimeException("Data access error"));
        GetForecastInputData inputData = new GetForecastInputData(cityName, new ArrayList<>());
        getForecastInteractor.execute(inputData);
        verify(mockGetForecastOutputBoundary).prepareFailView(errorMessage);}}
