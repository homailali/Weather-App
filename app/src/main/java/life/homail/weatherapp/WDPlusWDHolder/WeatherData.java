package life.homail.weatherapp.WDPlusWDHolder;

public class WeatherData{
    // Fields
    private String maxTemp;
    private String minTemp;
    private String actualTemp;
    private String countryName;
    private String feelsLikeTemp;
    // Constructor
    public WeatherData(
            String maxTemp,
            String minTemp,
            String actualTemp,
            String feelsLikeTemp,
            String countryName
    ){
        this.maxTemp=maxTemp;
        this.minTemp=minTemp;
        this.actualTemp=actualTemp;
        this.countryName=countryName;
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
    public String getCountryName() {
        return countryName;
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
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public void setFeelsLikeTemp(String feelsLikeTemp) {
        this.feelsLikeTemp = feelsLikeTemp;
    }
    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }
}