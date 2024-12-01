package use_case.search_city;

/**
 * DAO for the SearchCity Use Case.
 */
public interface SearchCityUserDataAccessInterface {

    /**
     * Search if the given city exists in the application.
     * @param cityname the username to look for
     * @return true if a user with the given username exists; false otherwise
     */
    boolean existsByName(String cityname);

}