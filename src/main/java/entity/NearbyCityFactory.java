package entity;

/**
 * Factory class for creating instances of {@link NearbyCity}.
 * Implements the {@link CityFactory} interface to provide a standardized way to create city objects.
 */
public class NearbyCityFactory implements CityFactory {

    /**
     * Creates a new {@link NearbyCity} instance with the specified properties.
     *
     * @param location   The location of the city.
     * @param temperature The temperature of the city.
     * @param condition  The weather condition of the city (e.g., sunny, rainy).
     * @param humidity   The humidity level of the city.
     * @return A new {@link NearbyCity} instance with the specified attributes.
     */
    public NearbyCity create(String location, double temperature, String condition, int humidity) {
        return new NearbyCity(location, temperature, condition, humidity);
    }
}
