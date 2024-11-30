package data_access;

import entity.City;
import entity.HistoryCity;
import entity.HistoryCityFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.weatherapp.MessageBox;
import use_case.get_history.GetHistoryDataAccessInterface;

import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HistoryWeatherInfoObject implements GetHistoryDataAccessInterface {

    private final HistoryCityFactory cityFactory;

    public HistoryWeatherInfoObject(HistoryCityFactory cityFactory) {
        this.cityFactory = cityFactory;
    }

    public City getWeatherHistory(String loc, int count){
        // Call API with the validated city
        String urlString = "http://api.openweathermap.org/data/2.5/forecast?q=" + loc +
                "&cnt=" + count + "&appid=a7053dadfa852680faa79393bbab3b4f";

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

        double temperatureThreeHoursAgo = Double.parseDouble(df.format(information.getJSONArray(
                "list").getJSONObject(0).getJSONObject("main").getDouble("temp") - 273.15));
        String conditionThreeHoursAgo = information.getJSONArray(
                "list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description");
        int humidityThreeHoursAgo = information.getJSONArray(
                "list").getJSONObject(0).getJSONObject("main").getInt("humidity");


        double temperatureSixHoursAgo = Double.parseDouble(df.format(information.getJSONArray(
                "list").getJSONObject(1).getJSONObject("main").getDouble("temp") - 273.15));
        String conditionSixHoursAgo = information.getJSONArray(
                "list").getJSONObject(1).getJSONArray("weather").getJSONObject(0).getString("description");
        int humiditySixHoursAgo = information.getJSONArray(
                "list").getJSONObject(1).getJSONObject("main").getInt("humidity");

        double temperatureNineHoursAgo = Double.parseDouble(df.format(information.getJSONArray(
                "list").getJSONObject(2).getJSONObject("main").getDouble("temp") - 273.15));
        String conditionNineHoursAgo = information.getJSONArray(
                "list").getJSONObject(2).getJSONArray("weather").getJSONObject(0).getString("description");
        int humidityNineHoursAgo = information.getJSONArray(
                "list").getJSONObject(2).getJSONObject("main").getInt("humidity");

        List<String> threeHoursAgo = cityFactory.HistoryCertainHour(
                temperatureThreeHoursAgo, conditionThreeHoursAgo, humidityThreeHoursAgo);
        List<String> sixHoursAgo = cityFactory.HistoryCertainHour(
                temperatureSixHoursAgo, conditionSixHoursAgo, humiditySixHoursAgo);
        List<String> nineHoursAgo = cityFactory.HistoryCertainHour(
                temperatureNineHoursAgo, conditionNineHoursAgo, humidityNineHoursAgo);

        List<List<String>> history = new ArrayList<>();
        history.add(threeHoursAgo);
        history.add(sixHoursAgo);
        history.add(nineHoursAgo);

        return cityFactory.create(location, temperature, condition, humidity, history);
    }

}
