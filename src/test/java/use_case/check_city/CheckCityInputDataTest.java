package use_case.check_city;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckCityInputDataTest {

    @Test
    void constructor_and_getters() {
        String cityName = "Toronto";
        CheckCityInputData inputData = new CheckCityInputData(cityName);

        assertEquals(cityName, inputData.getCityName());
    }
}
