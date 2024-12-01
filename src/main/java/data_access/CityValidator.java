package data_access;

public class CityValidator {

    /**
     * Validates whether a city name is valid.
     * @param city The city name to validate.
     * @return True if the city is valid, false otherwise.
     */
    public static boolean isCityValid(String city) {
        // Add validation logic here, e.g., checking against a predefined list of cities.
        return city != null && !city.trim().isEmpty();
    }
}
