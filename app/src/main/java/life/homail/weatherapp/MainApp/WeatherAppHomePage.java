package life.homail.weatherapp.MainApp;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;

import life.homail.weatherapp.R;
import androidx.appcompat.app.AppCompatActivity;
public class WeatherAppHomePage extends AppCompatActivity {
    //https://api.openweathermap.org/data/2.5/forecast?q=+chakwal+&appid=93c9ca708312cfa9cbfcd056848cb0de;
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






    private void wAHVObjectSettings(){

        this.wAppHomeViews=new WAppHomeViews(this);
    }
    private void changeStatusBarColor(){
        // Understand this function it is very important
        Window window = getWindow();
        window.setStatusBarColor(Color.WHITE);
    }
}