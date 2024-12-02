package data_access;

import entity.NearbyCity;
import entity.NearbyCityFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.weatherapp.MessageBox;
import use_case.nearby_cities.NearbyCitiesDataAccessInterface;

import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class NearbyCityWeatherAccessObject implements NearbyCitiesDataAccessInterface {

    private final ArrayList<NearbyCity> nearbyCities;
    private final NearbyCityFactory nearbyCityFactory;

    public NearbyCityWeatherAccessObject(NearbyCityFactory nearbyCityFactory) {
        this.nearbyCityFactory = nearbyCityFactory;
        nearbyCities = new ArrayList<>();
    }

    public ArrayList<NearbyCity> getNearbyCities(String loc){
        // Call API with the validated city
        String urlString = "http://api.openweathermap.org/data/2.5/forecast?q=" + loc +
                "&cnt=1&appid=a7053dadfa852680faa79393bbab3b4f";

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

        double curLong = Double.parseDouble(df.format(information.getJSONObject("city").
                getJSONObject("coord").getDouble("lon")));
        double curLat = Double.parseDouble(df.format(information.getJSONObject("city").
                getJSONObject("coord").getDouble("lat")));
        ArrayList<String> nearbyCityNames = new ArrayList<>();
        nearbyCityNames.add(information.getJSONObject("city").getString("name"));

        for(int i=-50; i<=50; i+=20){
            for(int j=-50; j<=50; j+=20){
                double nearbyLong = Double.parseDouble(df.format(curLong+(i/1000.0)));
                double nearbyLat = Double.parseDouble(df.format(curLat+(j/1000.0)));

                String nearbyCityUrlString = "http://api.openweathermap.org/data/2.5/forecast?lat=" + nearbyLat +
                        "&lon=" + nearbyLong + "&cnt=1&appid=a7053dadfa852680faa79393bbab3b4f";

                JSONObject nearbyCityInformation = null;

                final OkHttpClient nearbyCityClient = new OkHttpClient().newBuilder().build();
                final Request nearbyCityRequest = new Request.Builder().url(nearbyCityUrlString).build();
                try {
                    final Response response = nearbyCityClient.newCall(nearbyCityRequest).execute();
                    nearbyCityInformation = new JSONObject(response.body().string());

                    String nearbyLocation = nearbyCityInformation.getJSONObject("city").getString("name");
                    double nearbyTemperature = Double.parseDouble(df.format(nearbyCityInformation.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp") - 273.15));
                    String nearbyCondition = nearbyCityInformation.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description");
                    int nearbyHumidity = nearbyCityInformation.getJSONArray("list").getJSONObject(0).getJSONObject("main").getInt("humidity");

                    if(!nearbyCityNames.contains(nearbyCityInformation.getJSONObject("city").getString("name"))){
                        nearbyCityNames.add(nearbyCityInformation.getJSONObject("city").getString("name"));
                        nearbyCities.add(nearbyCityFactory.create(nearbyLocation, nearbyTemperature, nearbyCondition, nearbyHumidity));
                    }
                } catch (Exception e) {
                }
            }
        }
        return nearbyCities;
    }
}
