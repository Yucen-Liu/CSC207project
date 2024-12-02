package use_case.check_city;

import data_access.CurWeatherInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckCityInteractorTest {
    private CurWeatherInfo mockDataAccess; // Updated type
    private CheckCityOutputBoundary mockOutputBoundary;
    private CheckCityInteractor interactor;

    @BeforeEach
    void setUp() {
        mockDataAccess = mock(CurWeatherInfo.class); // Mock the correct type
        mockOutputBoundary = mock(CheckCityOutputBoundary.class);
        interactor = new CheckCityInteractor(mockDataAccess, mockOutputBoundary); // Use the correct type
    }

    @Test
    void validateCity_success() {
        String validCity = "Toronto";
        when(mockDataAccess.existsByName(validCity)).thenReturn(true);

        boolean result = interactor.validateCity(validCity);

        assertTrue(result);
        verify(mockOutputBoundary).presentSuccess(validCity);
    }

    @Test
    void validateCity_failure() {
        String invalidCity = "Atlantis";
        when(mockDataAccess.existsByName(invalidCity)).thenReturn(false);

        boolean result = interactor.validateCity(invalidCity);

        assertFalse(result);
        verify(mockOutputBoundary).presentFailure("City not found: " + invalidCity);
    }

    @Test
    void execute_success() {
        String validCity = "Toronto";
        CheckCityInputData inputData = new CheckCityInputData(validCity);

        when(mockDataAccess.existsByName(validCity)).thenReturn(true);

        interactor.execute(inputData);

        verify(mockOutputBoundary).presentSuccess(validCity);
    }

    @Test
    void execute_failure() {
        String invalidCity = "Atlantis";
        CheckCityInputData inputData = new CheckCityInputData(invalidCity);

        when(mockDataAccess.existsByName(invalidCity)).thenReturn(false);

        interactor.execute(inputData);

        verify(mockOutputBoundary).presentFailure("City not found: " + invalidCity);
    }
}
