package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.weatherapp.MessageBox;

import javax.swing.*;

public class CurWeatherInfoObject implements CurWeatherInfo {
    public JSONObject getCurWeather(String location){
        // Call API with the validated city
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location +
                "&appid=a7053dadfa852680faa79393bbab3b4f";

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
        return information;
    }
}
