package entity;

import java.util.ArrayList;
import java.util.List;

public class DetailedCityFactory implements CityFactory {
    public DetailedCity create(String location, double temperature, String condition, int humidity, double temp_max,
                               double temp_min, int pressure, int visibility) {
        return new DetailedCity(location, temperature, condition, humidity,temp_max, temp_min, pressure, visibility);
    }

    @Override
    public DetailedCity create(String location, double temperature, String condition, int humidity){
        double temp_min = -1000000;
        double temp_max = -1000000;
        int pressure = -1000000;
        int visibility = -1000000;

        return new DetailedCity(location,temperature,condition,humidity,temp_min,temp_max,pressure,visibility);

    }
}
