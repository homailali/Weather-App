package life.homail.weatherapp.WDPlusWDHolder;
public class WDHolder{
    // Constructor
    private WeatherData weatherData;
    private boolean ifAllowedToSetData;
    private static WDHolder wdHolder=new WDHolder();
    // Methods
    // Getters
    public static WDHolder getWdHolder(){
        return wdHolder;
    }

    public boolean getIfAllowedToSetData() {
        return ifAllowedToSetData;
    }
    public WeatherData getWeatherData(){
        return weatherData;
    }
    public void setWeatherData(WeatherData weatherData){
        this.weatherData=weatherData;
    }

    public void setIfAllowedToSetData(boolean ifAllowedToSetData) {
        this.ifAllowedToSetData = ifAllowedToSetData;
    }
}
