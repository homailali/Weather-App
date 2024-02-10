package life.homail.weatherapp.HomePage;
import android.os.Handler;
import life.homail.weatherapp.WDPlusWDHolder.WDHolder;
public class SetValuesForTempInHP {
    // Fields
    private WeatherAppHomePage weatherAppHomePage;
    private Handler handler=new Handler();
    // Constructor
    public SetValuesForTempInHP(WeatherAppHomePage weatherAppHomePage) {
        this.weatherAppHomePage = weatherAppHomePage;
    }
    // Methods
    protected void setValuesForTempInHPMain(){
        if (WDHolder.getWdHolder().getIfAllowedToSetData()){
            this.setValuesForTextFields();
            WDHolder.getWdHolder().setWeatherData(null);
            WDHolder.getWdHolder().setIfAllowedToSetData(false);
        }
    }
    private void setValuesForTextFields(){
        this.weatherAppHomePage.wAppHomeViews.actualTempTv.setText(WDHolder.getWdHolder().getWeatherData().getActualTemp()+"°C");
        this.weatherAppHomePage.wAppHomeViews.feelsLikeTv.setText("Feels like "+WDHolder.getWdHolder().getWeatherData().getFeelsLikeTemp()+"°C");
        this.weatherAppHomePage.wAppHomeViews.minTempTv.setText("˅ "+WDHolder.getWdHolder().getWeatherData().getMinTemp()+"°C");
        this.weatherAppHomePage.wAppHomeViews.maxTempTv.setText("^ "+WDHolder.getWdHolder().getWeatherData().getMaxTemp()+"°C");
        this.weatherAppHomePage.wAppHomeViews.cityNameTv.setText(WDHolder.getWdHolder().getWeatherData().getCountryName());
    }
}
