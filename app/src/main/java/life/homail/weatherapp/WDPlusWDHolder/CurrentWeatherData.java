package life.homail.weatherapp.WDPlusWDHolder;

public class CurrentWeatherData {
    // Fields
    private String maxTemp;
    private String minTemp;
    private String actualTemp;
    private String cityName;
    private String feelsLikeTemp;


    // Constructor
    public CurrentWeatherData(
            String maxTemp,
            String minTemp,
            String actualTemp,
            String feelsLikeTemp,
            String cityName
    ){
        this.maxTemp=maxTemp;
        this.minTemp=minTemp;
        this.actualTemp=actualTemp;
        this.cityName=cityName;
        this.feelsLikeTemp=feelsLikeTemp;
    }
    // Methods
    // Getters
    public String getMaxTemp() {

        return maxTemp;
    }
    public String getMinTemp() {

        return minTemp;
    }
    public String getActualTemp() {

        return actualTemp;
    }
    public String getCityName() {

        return cityName;
    }
    public String getFeelsLikeTemp() {

        return feelsLikeTemp;
    }
    // Setters
    public void setMinTemp(String minTemp) {

        this.minTemp = minTemp;
    }
    public void setActualTemp(String actualTemp) {

        this.actualTemp = actualTemp;
    }
    public void setCityName(String cityName) {

        this.cityName = cityName;
    }
    public void setFeelsLikeTemp(String feelsLikeTemp) {

        this.feelsLikeTemp = feelsLikeTemp;
    }
    public void setMaxTemp(String maxTemp) {

        this.maxTemp = maxTemp;
    }
}