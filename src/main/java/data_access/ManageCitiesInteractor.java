package data_access;

import use_case.cities.CityValidationInterface;

public class ManageCitiesInteractor {
    private final CityValidationInterface cityValidator;

    public ManageCitiesInteractor(CityValidationInterface cityValidator) {
        this.cityValidator = cityValidator;
    }

    public boolean isCityValid(String city) {
        return cityValidator.isCityValid(city);
    }
}
