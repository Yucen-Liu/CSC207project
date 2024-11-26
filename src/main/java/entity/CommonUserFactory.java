package entity;

/**
 * Factory for creating CommonUser objects.
 */
public class CommonUserFactory implements UserFactory {

    @Override
    public User create(String name, String password, CityStorage cities) {
        return new CommonUser(name, password, cities);
    }
}

