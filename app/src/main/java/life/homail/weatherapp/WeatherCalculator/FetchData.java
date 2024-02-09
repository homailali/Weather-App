package life.homail.weatherapp.WeatherCalculator;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URL;
import life.homail.weatherapp.WDPlusWDHolder.WDHolder;
import life.homail.weatherapp.WDPlusWDHolder.WeatherData;
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
        } catch (Exception exception){
            Log.d("inApi","Error on bg");
        }
        return data;
    }
    @Override
    public void onPostExecute(String finalWeather){
        String actualTemp;
        String minTemp;
        String maxTemp;
        String feelsLikeTemp;
        if (finalWeather!=null){
            try {
                JSONObject jsonObject = new JSONObject(finalWeather);
                JSONArray jsonArray=jsonObject.getJSONArray("list");
                JSONObject firstJSONObj=jsonArray.getJSONObject(0);
                JSONObject main=firstJSONObj.getJSONObject("main");
                actualTemp=kelvinToCelsius(main.getDouble("temp"));
                minTemp=kelvinToCelsius(main.getDouble("temp_min"));
                maxTemp=kelvinToCelsius(main.getDouble("temp_max"));
                feelsLikeTemp=kelvinToCelsius(main.getDouble("feels_like"));
                this.makeAndInitializeWDObj(maxTemp,minTemp,actualTemp,feelsLikeTemp);
            } catch (Exception exception){}
        } else {
            WDHolder.getWdHolder().setWeatherData(null);
        }
    }
    private String kelvinToCelsius(double kelvin){
        long celsius=(long)(kelvin-273);
        return String.valueOf(celsius);
    }
    private void makeAndInitializeWDObj(String maxTemp,String minTemp,String actualTemp,String feelsLike){
        WeatherData weatherData=new WeatherData(maxTemp,minTemp,actualTemp,feelsLike,this.wcMain.cityName);
        WDHolder.getWdHolder().setWeatherData(weatherData);
    }
}