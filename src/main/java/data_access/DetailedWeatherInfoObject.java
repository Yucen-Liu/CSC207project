package data_access;

import entity.City;
import entity.CommonCityFactory;
import entity.DetailedCity;
import entity.DetailedCityFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.weatherapp.MessageBox;
import use_case.get_details.GetDetailsDataAccessInterface;
import use_case.get_forecast.GetForecastDataAccessInterface;

import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DetailedWeatherInfoObject implements GetDetailsDataAccessInterface {
    private final DetailedCityFactory cityFactory;

    public DetailedWeatherInfoObject(DetailedCityFactory cityFactory) {
        this.cityFactory = cityFactory;
    }
    @Override
    public DetailedCity getDetailedWeather(String loc){
        // Call API with the validated city
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + loc +
                "&appid=a7053dadfa852680faa79393bbab3b4f";

        // Rounding for temperature
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        JSONObject information = null;

        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder().url(urlString).build();
        try {
            final Response response = client.newCall(request).execute();
            information = new JSONObject(response.body().string());
        } catch (Exception e) {
            MessageBox.showWarningNoLoc(new JFrame());
            return null;
        }

        String location = information.getString("name");
        double temperature = Double.parseDouble(df.format(information.getJSONObject("main").getDouble("temp") - 273.15));
        String condition = information.getJSONArray("weather").getJSONObject(0).getString("description");
        int humidity = information.getJSONObject("main").getInt("humidity");

        return cityFactory.create(location, temperature, condition, humidity);
    }
}