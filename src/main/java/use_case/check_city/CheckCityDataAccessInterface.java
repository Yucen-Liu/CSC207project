package use_case.check_city;

/**
 * DAO for the CheckCity Use Case.
 */
public interface CheckCityDataAccessInterface {

    /**
     * Checks if the given city exists in the application.
     * @param cityname the username to look for
     * @return true if a user with the given username exists; false otherwise
     */
    boolean existsByName(String cityname);

}
