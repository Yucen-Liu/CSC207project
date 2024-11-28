package entity;

/**
 * A user in the Weather System Program.
 */
public interface User {

    /**
     * Returns the username of the user.
     * @return the username of the user.
     */
    String getName();

    /**
     * Returns the password of the user.
     * @return the password of the user.
     */
    String getPassword();

    /**
     * Returns the cities saved by the user.
     * @return the cities saved by the user.
     */
    CityStorage getCities();

}