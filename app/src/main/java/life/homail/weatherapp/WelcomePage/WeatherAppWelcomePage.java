package life.homail.weatherapp.WelcomePage;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import life.homail.weatherapp.MainApp.WeatherAppHomePage;
import life.homail.weatherapp.R;
public class WeatherAppWelcomePage extends AppCompatActivity{
    // Fields
    protected Button getStartedBtn;
    protected static String sPCode="Once";
    protected static String spBoolKey="bool";
    protected boolean boolToOnlyShowWelComePageOnce=true;
    // Methods
    // Activity life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.retrieveBoolFromSpAndCheckItsValue();
        if (this.boolToOnlyShowWelComePageOnce){
            super.setContentView(R.layout.weather_app_welcome_page_activity);
            this.getStartedBtnSettings();
            this.changeStatusBarColor();
        } else this.goToWeatherAppMainPage();
    }

    // Retrieving data
    private void retrieveBoolFromSpAndCheckItsValue(){
        SharedPreferences sharedPreferences=getSharedPreferences(sPCode,MODE_PRIVATE);
        this.boolToOnlyShowWelComePageOnce=sharedPreferences.getBoolean(spBoolKey,true);
    }
    // Btn Settings and handling
    private void getStartedBtnSettings(){
        this.getStartedBtn=super.findViewById(R.id.getStartedBtn);
        this.getStartedBtn.setOnClickListener(this::getStartedBtnHandler);
    }
    private void getStartedBtnHandler(View view){
        this.boolToOnlyShowWelComePageOnce=false;
        this.addBoolToSp();
        this.goToWeatherAppMainPage();
    }
    private void addBoolToSp(){
        SharedPreferences sharedPreferences=getSharedPreferences(sPCode,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(spBoolKey,this.boolToOnlyShowWelComePageOnce);
        editor.apply();
    }
    private void goToWeatherAppMainPage(){
        Intent intent=new Intent(WeatherAppWelcomePage.this, WeatherAppHomePage.class);
        super.startActivity(intent);
        super.finish();
    }
    // Others
    private void changeStatusBarColor(){
        Window window=super.getWindow();
        window.setStatusBarColor(Color.parseColor("#47449B"));
    }
}