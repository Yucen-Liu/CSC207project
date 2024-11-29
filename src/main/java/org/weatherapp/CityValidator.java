package org.weatherapp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class CityValidator {
    private static final String API_KEY = "a7053dadfa852680faa79393bbab3b4f";

    public static boolean isCityValid(String city) {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY;

        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder().url(urlString).build();
        try {
            final Response response = client.newCall(request).execute();

            if (!response.isSuccessful() || response.body() == null) {
                return false; // City is not valid
            }

            JSONObject information = new JSONObject(response.body().string());
            return information.has("name"); // Check if the response contains a city name
        } catch (IOException | JSONException e) {
            return false; // Error indicates invalid city
        }
    }
}
