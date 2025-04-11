package due.giuaky221121514222.day3.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import due.giuaky221121514222.BaseScreen;
import due.giuaky221121514222.day3.adapter.HourAdapter;
import due.giuaky221121514222.day3.model.Weather;
import due.giuaky221121514222.day3.network.Weather_ApiManager;

import java.util.List;

import due.giuaky221121514222.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends BaseScreen {
    private RecyclerView rvHour;
    private TextView tvTem;
    private TextView tvStatus;

    @Override
    protected int getLayoutResource() {
        return R.layout.day3_activity_weather;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        tvTem = (TextView) findViewById(R.id.tvTem);
        tvStatus= (TextView) findViewById(R.id.tvStatus);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rvHour= (RecyclerView) findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);
        getHours();

    }
    private void getHours(){
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Weather_ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Weather_ApiManager service = retrofit.create(Weather_ApiManager.class);
        service.getHour("353412", "tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh", "vi-vn", true).enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response){
                if (!response.isSuccessful() || response.body() == null) {
                    Log.e("API_ERROR", "Response error: " + response.errorBody());
                    return;
                }
                List<Weather> listWeather = response.body();
                if (listWeather.isEmpty()) {
                    Log.e("API_ERROR", "Empty list received");
                    return;
                }
                HourAdapter adapter = new HourAdapter(WeatherActivity.this, listWeather);
                rvHour.setAdapter(adapter);
                Weather weather = listWeather.get(0);
                tvTem.setText(weather.getTemperature().getValue().intValue()+"°");
                tvStatus.setText(weather.getIconPhrase());

            }
            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t){
                Log.e("API_ERROR", "Failure: " + t.getMessage());
            }
        });
    }
}
