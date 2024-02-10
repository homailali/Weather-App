package life.homail.weatherapp.WeatherCalculator;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import life.homail.weatherapp.WDPlusWDHolder.FeatureDataClass;
import life.homail.weatherapp.WDPlusWDHolder.WDHolder;
import life.homail.weatherapp.WDPlusWDHolder.CurrentWeatherData;

public class FetchData extends AsyncTask<URL,Void,String>{
    // Fields
    private WCMain wcMain;
    // Constructor
    public FetchData(WCMain wcMain) {
        this.wcMain = wcMain;
    }
    // Methods
    @Override
    public String doInBackground(URL... urls){
        URL url=urls[0];
        String data=null;
        try {
            data=NetworkUtils.makeRequest(url);
        } catch (Exception exception){}
        return data;
    }
    @Override
    public void onPostExecute(String finalWeather){
        int count=1;
        String actualTemp;
        String minTemp;
        String maxTemp;
        String feelsLikeTemp;
        // Feature weather
        if (finalWeather!=null){
            try {
                JSONObject jsonObject = new JSONObject(finalWeather);
                JSONArray jsonArray=jsonObject.getJSONArray("list");
                JSONObject firstJSONObj=jsonArray.getJSONObject(0);
                JSONObject main=firstJSONObj.getJSONObject("main");
                // Current Weather
                actualTemp=kelvinToCelsius(main.getDouble("temp"));
                minTemp=kelvinToCelsius(main.getDouble("temp_min"));
                maxTemp=kelvinToCelsius(main.getDouble("temp_max"));
                feelsLikeTemp=kelvinToCelsius(main.getDouble("feels_like"));
                this.makeAndInitializeCWDObj(maxTemp,minTemp,actualTemp,feelsLikeTemp);
                Log.d("inApi",String.valueOf(getDayTime(firstJSONObj.getString("dt_txt"))));
                // Feature weather
                while (count< jsonArray.length()) {
                    JSONObject ithJsonObject = jsonArray.getJSONObject(count);
                    JSONObject ithMain = ithJsonObject.getJSONObject("main");
                    String dayDate = this.getDayDate(ithJsonObject.getString("dt_txt"));
                    String dayTemp = this.kelvinToCelsius(ithMain.getDouble("temp"))+"°C";
                    String dayTime = this.getDayTime(ithJsonObject.getString("dt_txt"));
                    WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass(dayDate, dayTime,dayTemp));
                    count++;
                }
            } catch (Exception ignored){}
        } else {
            WDHolder.getWdHolder().setCurrentWeatherData(null);
        }
    }
    private String getDayDate(String dateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.UK);
        Date date = sdf.parse(dateTime);
        SimpleDateFormat dateSdf = new SimpleDateFormat("dd/MM/yyyy",Locale.UK);
        return dateSdf.format(date);
    }
    private String getDayTime(String dateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.UK);
        Date date = sdf.parse(dateTime);
        SimpleDateFormat timeSdf = new SimpleDateFormat("hh:mm a", Locale.UK);
        return timeSdf.format(date);
    }
    private String kelvinToCelsius(double kelvin){
        long celsius=(long)(kelvin-273);
        return String.valueOf(celsius);
    }
    private void makeAndInitializeCWDObj(String maxTemp,String minTemp,String actualTemp,String feelsLike){
        CurrentWeatherData currentWeatherData =new CurrentWeatherData(maxTemp,minTemp,actualTemp,feelsLike,this.wcMain.cityName);
        WDHolder.getWdHolder().setCurrentWeatherData(currentWeatherData);
    }
}