package entity;

import java.util.ArrayList;
import java.util.List;

public class DetailedCityFactory implements CityFactory {
    @Override
    public DetailedCity create(String location, double temperature, String condition, int humidity) {
        return new DetailedCity(location, temperature, condition, humidity);
    }
}
