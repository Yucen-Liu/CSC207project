package use_case.check_city;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckCityOutputDataTest {

    @Test
    void constructor_and_getters() {
        String cityName = "Toronto";
        boolean useCaseFailed = false;

        CheckCityOutputData outputData = new CheckCityOutputData(cityName, useCaseFailed);

        assertEquals(cityName, outputData.getCityName());
        assertFalse(outputData.isUseCaseFailed());
    }
}
