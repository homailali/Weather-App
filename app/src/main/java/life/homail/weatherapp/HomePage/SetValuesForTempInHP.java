package life.homail.weatherapp.HomePage;
import android.os.Handler;

import java.util.ArrayList;

import life.homail.weatherapp.WDPlusWDHolder.FeatureDataClass;
import life.homail.weatherapp.WDPlusWDHolder.WDHolder;
import life.homail.weatherapp.WeatherCalculator.WCMain;
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
            this.setValuesForCurrentData();
            WDHolder.getWdHolder().setCurrentWeatherData(null);
            WDHolder.getWdHolder().setIfAllowedToSetData(false);
        }
    }
    private void setValuesForCurrentData(){
        this.weatherAppHomePage.wAppHomeViews.actualTempTv.setText(WDHolder.getWdHolder().getCurrentWeatherData().getActualTemp()+"°C");
        this.weatherAppHomePage.wAppHomeViews.feelsLikeTv.setText("Feels like "+WDHolder.getWdHolder().getCurrentWeatherData().getFeelsLikeTemp()+"°C");
        this.weatherAppHomePage.wAppHomeViews.minTempTv.setText("˅ "+WDHolder.getWdHolder().getCurrentWeatherData().getMinTemp()+"°C");
        this.weatherAppHomePage.wAppHomeViews.maxTempTv.setText("^ "+WDHolder.getWdHolder().getCurrentWeatherData().getMaxTemp()+"°C");
        this.weatherAppHomePage.wAppHomeViews.cityNameTv.setText(WDHolder.getWdHolder().getCurrentWeatherData().getCityName());
    }
    // Others
    protected void getDataForFirstTime(){
        try {
            WCMain wcMain=new WCMain();
            wcMain.WCMainMethod("karachi");
        } catch (Exception exception){}
        this.handler.postDelayed(this::setDataForFirstTime,2000);
    }
    private void setDataForFirstTime(){
        if (WDHolder.getWdHolder().getCurrentWeatherData()!=null){
            WDHolder.getWdHolder().setIfAllowedToSetData(true);
            this.setValuesForTempInHPMain();
        }
    }
    protected void addDumbyDataToFeatureClassesArr(){
        WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass("dd/MM/yyyy","hh:mm a/p","T°C"));
        WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass("dd/MM/yyyy","hh:mm a/p","T°C"));
        WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass("dd/MM/yyyy","hh:mm a/p","T°C"));
        WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass("dd/MM/yyyy","hh:mm a/p","T°C"));
        WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass("dd/MM/yyyy","hh:mm a/p","T°C"));
        WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass("dd/MM/yyyy","hh:mm a/p","T°C"));
        WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass("dd/MM/yyyy","hh:mm a/p","T°C"));
        WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass("dd/MM/yyyy","hh:mm a/p","T°C"));
        WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass("dd/MM/yyyy","hh:mm a/p","T°C"));
        WDHolder.getWdHolder().getFeatureDataClassesArr().add(new FeatureDataClass("dd/MM/yyyy","hh:mm a/p","T°C"));
        this.weatherAppHomePage.adapter.notifyDataSetChanged();
    }
}