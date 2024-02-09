package life.homail.weatherapp.SearchPage;

import android.os.Handler;
import android.view.View;

import life.homail.weatherapp.WDPlusWDHolder.WDHolder;
import life.homail.weatherapp.WeatherCalculator.WCMain;

public class CheckWBtnHandler implements View.OnClickListener{
    // Fields
    private String cityName;
    private WAppSearchPgMain wAppSearchPgMain;
    // Constructor
    public CheckWBtnHandler(WAppSearchPgMain wAppSearchPgMain) {
        this.wAppSearchPgMain = wAppSearchPgMain;
    }
    // Methods
    @Override
    public void onClick(View view){
        this.cityName=this.wAppSearchPgMain.waSPViews.textField.getText().toString();
        if (cityName.isEmpty()) {
            this.onError();
        } else{
            WCMain wcMain=new WCMain();
            try {
                wcMain.WCMainMethod(this.cityName);
            } catch(Exception e){
                this.onError();
            }
            this.onLastOfOnClickBtn();
        }
    }


    private void onLastOfOnClickBtn(){
        new Handler().postDelayed(()->{
            if (WDHolder.getWdHolder().getWeatherData()==null) this.onError();
            else this.ifWDHolderIsNotNull();
        },10000);
    }

    private void ifWDHolderIsNotNull(){
        WDHolder.getWdHolder().setIfAllowedToSetData(true);
        this.wAppSearchPgMain.finish();
    }
    private void onError(){
        this.wAppSearchPgMain.waSPViews.textField.setText(null);
        this.wAppSearchPgMain.waSPViews.textField.setHint("Invalid city");
    }
}
