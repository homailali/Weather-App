package life.homail.weatherapp.HomePage;
import android.os.Handler;

import life.homail.weatherapp.WDPlusWDHolder.FeatureDataClass;
import life.homail.weatherapp.WDPlusWDHolder.WDHolder;
import life.homail.weatherapp.WeatherCalculator.WCMain;
public class SetValuesForTempInHP {
    // Fields
    private WAHomePageMain WAHomePageMain;
    private Handler handler=new Handler();
    // Constructor
    public SetValuesForTempInHP(WAHomePageMain WAHomePageMain) {
        this.WAHomePageMain = WAHomePageMain;
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
        this.WAHomePageMain.wAppHomeViews.actualTempTv.setText(WDHolder.getWdHolder().getCurrentWeatherData().getActualTemp()+"°C");
        this.WAHomePageMain.wAppHomeViews.feelsLikeTv.setText("Feels like "+WDHolder.getWdHolder().getCurrentWeatherData().getFeelsLikeTemp()+"°C");
        this.WAHomePageMain.wAppHomeViews.minTempTv.setText("˅ "+WDHolder.getWdHolder().getCurrentWeatherData().getMinTemp()+"°C");
        this.WAHomePageMain.wAppHomeViews.maxTempTv.setText("^ "+WDHolder.getWdHolder().getCurrentWeatherData().getMaxTemp()+"°C");
        this.WAHomePageMain.wAppHomeViews.cityNameTv.setText(WDHolder.getWdHolder().getCurrentWeatherData().getCityName());
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
        this.WAHomePageMain.adapter.notifyDataSetChanged();
    }
}