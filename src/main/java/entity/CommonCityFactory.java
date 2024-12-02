package entity;
/**
 * Factory for creating CommonCity objects.
 */
// City Factorys.
public class CommonCityFactory implements CityFactory {
    @Override
    public City create(String location, double temperature, String condition, int humidity) {
        return new CommonCity(location, temperature, condition, humidity);
    }
}
