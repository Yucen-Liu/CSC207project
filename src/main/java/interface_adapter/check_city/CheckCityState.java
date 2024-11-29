package interface_adapter.check_city;

public class CheckCityState {
    private String cityname = "";
    private String citynameResult;

    public String getCityname() {return cityname;}
    public void setCityname(String cityname) {this.cityname = cityname;}
    public String getCitynameResult() {return citynameResult;}
    public void setCitynameResult(String citynameError) {this.citynameResult = citynameError;}
}

