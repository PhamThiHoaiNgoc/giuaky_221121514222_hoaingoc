package due.giuaky221121514222.day3.network;

import due.giuaky221121514222.day3.model.Weather;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface Weather_ApiManager {
    String BASE_URL = "http://dataservice.accuweather.com/";

    @GET("forecasts/v1/hourly/12hour/{locationKey}")
    Call<List<Weather>> getHour(
            @Path("locationKey") String locationKey,
            @Query("apikey") String apiKey,
            @Query("language") String language,
            @Query("metric") boolean metric
    );
    @GET("forecasts/v1/daily/5day/{locationKey}")
    Call<List<Weather>> getDay(
            @Path("locationKey") String locationKey,
            @Query("apikey") String apiKey,
            @Query("language") String language,
            @Query("metric") boolean metric
    );
}