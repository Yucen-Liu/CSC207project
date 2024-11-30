package interface_adapter.check_city;

import entity.City;

import java.util.List;

/**
 * The state for the CheckCity View Model.
 */
public class CheckCityState {
    private String cityName = "";
    private String cityNameResult;
    private List<City> citiesSaved;

    public String getCityName() {return cityName;}
    public void setCityName(String cityName) {this.cityName = cityName;}
    public String getCityNameResult() {return cityNameResult;}
    public void setCityNameResult(String cityNameResult) {this.cityNameResult = cityNameResult;}
    public List<City> getCitiesSaved() {return citiesSaved;}
    public void setCitiesSaved(List<City> citiesSaved) {}
}


