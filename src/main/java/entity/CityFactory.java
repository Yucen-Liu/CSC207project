package entity;

/**
 * Factory for creating cities.
 */
public interface CityFactory {
    /**
     * Creates a new City.
     * @param location the name of the new city
     * @param temperature the password of the new city
     * @param condition the password of the new city
     * @param humidity the password of the new city
     * @return the new user
     */
    City create(String location, double temperature, String condition, int humidity);

}
