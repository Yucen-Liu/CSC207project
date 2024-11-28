package entity;

/**
 * An implementation of the User interface.
 */
public class CommonUser implements User {

    private final String name;
    private final String password;
    private final CityStorage cities;

    public CommonUser(String name, String password, CityStorage cities) {
        this.name = name;
        this.password = password;
        this.cities = cities;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public CityStorage getCities() {
        return cities;
    }

}