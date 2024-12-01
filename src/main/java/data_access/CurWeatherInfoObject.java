package data_access;

import entity.City;
import entity.CommonCityFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import use_case.check_city.CheckCityDataAccessInterface;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Data Access Object for retrieving current weather information and validating city names.
 */
public class CurWeatherInfoObject implements CurWeatherInfo, CheckCityDataAccessInterface {

    private final CommonCityFactory cityFactory;
    private final OkHttpClient httpClient;
    private static final String API_KEY = "a7053dadfa852680faa79393bbab3b4f";
    private static final String WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather";

    public CurWeatherInfoObject(CommonCityFactory cityFactory) {
        this.cityFactory = cityFactory;
        this.httpClient = new OkHttpClient.Builder().build();
    }

    @Override
    public City getCurWeather(String location) {
        String urlString = WEATHER_API_URL + "?q=" + location + "&appid=" + API_KEY;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        try {
            JSONObject responseJson = fetchWeatherData(urlString);
            String cityName = responseJson.getString("name");
            double temperature = Double.parseDouble(df.format(responseJson.getJSONObject("main").getDouble("temp") - 273.15));
            String condition = responseJson.getJSONArray("weather").getJSONObject(0).getString("description");
            int humidity = responseJson.getJSONObject("main").getInt("humidity");

            return cityFactory.create(cityName, temperature, condition, humidity);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving current weather: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean existsByName(String cityName) {
        String urlString = WEATHER_API_URL + "?q=" + cityName + "&appid=" + API_KEY;

        try {
            fetchWeatherData(urlString); // If the request succeeds, the city exists
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private JSONObject fetchWeatherData(String urlString) throws Exception {
        Request request = new Request.Builder().url(urlString).build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) {
                throw new Exception("Failed to retrieve data from weather API.");
            }
            return new JSONObject(response.body().string());
        }
    }
}
