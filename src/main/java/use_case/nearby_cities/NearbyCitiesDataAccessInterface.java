package use_case.nearby_cities;

import entity.NearbyCity;

import java.util.List;

public interface NearbyCitiesDataAccessInterface {
    List<NearbyCity> getWeatherHistory(String loc);
}
