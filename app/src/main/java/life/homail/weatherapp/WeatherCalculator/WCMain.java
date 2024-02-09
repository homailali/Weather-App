package life.homail.weatherapp.WeatherCalculator;
import android.net.Uri;
import java.net.URL;
public class WCMain {
    // Fields
    protected String cityName;
    // Constructor
    public void WCMainMethod(String cityName) throws Exception {
        this.cityName=cityName;
        this.getUrl();
    }
    // Methods
    private void getUrl() throws Exception{
        Uri uri=Uri.parse("https://api.openweathermap.org/data/2.5/forecast?q="+cityName+"&appid=93c9ca708312cfa9cbfcd056848cb0de")
                .buildUpon().build();
        URL url=new URL(String.valueOf(uri));
        FetchData getWeather=new FetchData(this);
        getWeather.execute(url);
    }
}
