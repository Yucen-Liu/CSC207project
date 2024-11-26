package entity;

/**
 * A city in the Weather System Program.
 */
public interface City {
    /**
     * Returns the location of the city.
     * @return the location of the city.
     */
    String getLocation();

    /**
     * Returns the temperature of the city.
     * @return the temperature of the city.
     */
    float getTemperature();

    /**
     * Returns the condition of the city.
     * @return the condition of the city.
     */
    String getCondition();

    /**
     * Returns the humidity of the city.
     * @return the humidity of the city.
     */
    int getHumidity();

}
