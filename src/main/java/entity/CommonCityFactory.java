package entity;
/**
 * Factory for creating CommonCity objects.
 */
public class CommonCityFactory implements CityFactory {
    @Override
    public City create(String location, double temperature, String condition, int humidity) {
        return new CommonCity(location, temperature, condition, humidity);
    }
}
