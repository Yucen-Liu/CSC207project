package use_case.nearby_cities;

import entity.NearbyCity;

import java.util.ArrayList;
import java.util.List;

public interface NearbyCitiesDataAccessInterface {
    ArrayList<NearbyCity> getNearbyCities(String loc);
}
