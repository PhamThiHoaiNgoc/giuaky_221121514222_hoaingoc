package due.giuaky221121514222.day3.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import due.giuaky221121514222.R;
import due.giuaky221121514222.day3.model.Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HourAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Weather> listWeather;

    public HourAdapter(Activity activity, List<Weather> listWeather) {
        this.activity = activity;
        this.listWeather = listWeather;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = activity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.day3_item_hour, parent, false);
        HourHolder holder = new HourHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HourHolder vh = (HourHolder) holder;
        Weather weather = listWeather.get(position);
        vh.tvTime.setText(convertTime(weather.getDateTime()));
        vh.tvTem.setText(weather.getTemperature().getValue() + "");

        String url;
        if (weather.getWeatherIcon() < 10) {
            url = "http://developer.accuweather.com/sites/default/files/0" + weather.getWeatherIcon() + "-s.png";
        } else {
            url = "http://developer.accuweather.com/sites/default/files/" + weather.getWeatherIcon() + "-s.png";
        }

        Glide.with(activity).load(url).into(vh.icon);
    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }


    public static class HourHolder extends RecyclerView.ViewHolder {
        private TextView tvTime;
        private TextView tvTem;
        private ImageView icon;

        public HourHolder(View itemView) {
            super(itemView);
            tvTime =(TextView) itemView.findViewById(R.id.tvTime);

            icon = (ImageView) itemView.findViewById(R.id.icon);
            tvTem = (TextView) itemView.findViewById(R.id.tvTem);
        }
    }
    public String convertTime(String inputTime){
        SimpleDateFormat inFormat = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try{
            date= inFormat.parse(inputTime);
        }catch (ParseException e){
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }
}
