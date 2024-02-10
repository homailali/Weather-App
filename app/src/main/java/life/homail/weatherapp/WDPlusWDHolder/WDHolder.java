package life.homail.weatherapp.WDPlusWDHolder;

import java.util.ArrayList;

public class WDHolder{
    // Constructor
    private CurrentWeatherData currentWeatherData;
    private boolean ifAllowedToSetData;
    private ArrayList<FeatureDataClass> featureDataClassesArr=new ArrayList<>();

    public ArrayList<FeatureDataClass> getFeatureDataClassesArr() {
        return featureDataClassesArr;
    }

    public void setFeatureDataClassesArr(ArrayList<FeatureDataClass> featureDataClassesArr) {
        this.featureDataClassesArr = featureDataClassesArr;
    }

    private static WDHolder wdHolder=new WDHolder();
    // Methods
    public static WDHolder getWdHolder(){

        return wdHolder;
    }

    public boolean getIfAllowedToSetData() {

        return ifAllowedToSetData;
    }
    public CurrentWeatherData getCurrentWeatherData(){

        return currentWeatherData;
    }
    public void setCurrentWeatherData(CurrentWeatherData currentWeatherData){

        this.currentWeatherData = currentWeatherData;
    }
    public void setIfAllowedToSetData(boolean ifAllowedToSetData) {

        this.ifAllowedToSetData = ifAllowedToSetData;
    }
}