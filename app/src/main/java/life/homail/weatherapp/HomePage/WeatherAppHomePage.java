package life.homail.weatherapp.HomePage;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;

import life.homail.weatherapp.R;
import life.homail.weatherapp.WDPlusWDHolder.WDHolder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class WeatherAppHomePage extends AppCompatActivity {
    // Fields
    protected WAppHomeViews wAppHomeViews;
    protected SetValuesForTempInHP setValuesForTempInHP=new SetValuesForTempInHP(this);
    // Adapter
    protected Adapter adapter;
    // Methods
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.weather_app_home_page_activity);
        this.changeStatusBarColor();
        this.wAHVObjectSettings();
        this.adapterSettings();
        this.rcViewSettings();
        this.setValuesForTempInHP.addDumbyDataToFeatureClassesArr();
    }
    @Override
    protected void onStart(){
        super.onStart();
        this.adapter.notifyDataSetChanged();
        this.setValuesForTempInHP.setValuesForTempInHPMain();
    }
    private void wAHVObjectSettings(){

        this.wAppHomeViews=new WAppHomeViews(this);
    }
    private void rcViewSettings(){
        LinearLayoutManager linearLayoutManage=new LinearLayoutManager(this);
        linearLayoutManage.setOrientation(LinearLayoutManager.HORIZONTAL);
        this.wAppHomeViews.rcView.setLayoutManager(linearLayoutManage);
        this.wAppHomeViews.rcView.setAdapter(this.adapter);
    }
    private void adapterSettings(){
        this.adapter=new Adapter(this);
    }

    private void changeStatusBarColor(){
        // Understand this function it is very important
        Window window = getWindow();
        window.setStatusBarColor(Color.WHITE);
    }
}