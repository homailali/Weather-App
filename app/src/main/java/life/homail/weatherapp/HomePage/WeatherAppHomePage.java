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
    protected SetValuesForTempInHP setValuesForTempInHP=new SetValuesForTempInHP(this);
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
        this.setValuesForTempInHP.setValuesForTempInHPMain();
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