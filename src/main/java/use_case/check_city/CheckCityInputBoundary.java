package use_case.check_city;

/**
 * Input Boundary for actions related to checking city information.
 */
public interface CheckCityInputBoundary {
    /**
     * Validates the city name directly.
     *
     * @param cityName the name of the city to validate
     */
    boolean validateCity(String cityName);

    /**
     * Executes the check city use case with structured input data.
     *
     * @param inputData the input data containing the city name and additional information
     */
    void execute(CheckCityInputData inputData);
}
