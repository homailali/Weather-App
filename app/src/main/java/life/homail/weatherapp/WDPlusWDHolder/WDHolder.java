package life.homail.weatherapp.WDPlusWDHolder;
public class WDHolder{
    // Constructor
    private WeatherData weatherData;
    private boolean ifAllowedToSetData=false;

    private static WDHolder wdHolder=new WDHolder();
    // Methods

    // Getters
    public static WDHolder getWdHolder(){
        return wdHolder;
    }

    public boolean getIsIfAllowedToSetData() {
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
