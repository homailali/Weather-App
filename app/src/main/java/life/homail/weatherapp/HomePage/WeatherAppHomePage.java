package life.homail.weatherapp.HomePage;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;

import life.homail.weatherapp.R;
import life.homail.weatherapp.WDPlusWDHolder.WDHolder;

import androidx.appcompat.app.AppCompatActivity;
public class WeatherAppHomePage extends AppCompatActivity {
    // Fields
    protected WAppHomeViews wAppHomeViews;


    // Methods
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.weather_app_home_page_activity);
        this.changeStatusBarColor();
        this.wAHVObjectSettings();
    }

    @Override
    protected void onStart(){
        super.onStart();
        if (WDHolder.getWdHolder().getIsIfAllowedToSetData()){
            this.setValuesForTextFields();
            WDHolder.getWdHolder().setIfAllowedToSetData(false);
        }
    }
    private void setValuesForTextFields(){
        this.wAppHomeViews.actualTempTv.setText(WDHolder.getWdHolder().getWeatherData().getActualTemp()+"°C");
        this.wAppHomeViews.feelsLikeTv.setText("Feels like "+WDHolder.getWdHolder().getWeatherData().getFeelsLikeTemp()+"°C");
        this.wAppHomeViews.minTempTv.setText("˅ "+WDHolder.getWdHolder().getWeatherData().getMinTemp()+"°C");
        this.wAppHomeViews.maxTempTv.setText("^ "+WDHolder.getWdHolder().getWeatherData().getMaxTemp()+"°C");
        this.wAppHomeViews.cityNameTv.setText(WDHolder.getWdHolder().getWeatherData().getCountryName());
    }




    private void wAHVObjectSettings(){

        this.wAppHomeViews=new WAppHomeViews(this);
    }
    private void changeStatusBarColor(){
        // Understand this function it is very important
        Window window = getWindow();
        window.setStatusBarColor(Color.WHITE);
    }
}