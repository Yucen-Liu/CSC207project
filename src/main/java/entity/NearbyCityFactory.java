package entity;

public class NearbyCityFactory implements CityFactory{
    public NearbyCity create(String location, double temperature, String condition, int humidity) {
        return new NearbyCity(location, temperature, condition, humidity);
    }
}
