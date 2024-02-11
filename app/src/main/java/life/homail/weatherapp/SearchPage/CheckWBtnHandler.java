package life.homail.weatherapp.SearchPage;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;

import life.homail.weatherapp.WDPlusWDHolder.WDHolder;
import life.homail.weatherapp.WeatherCalculator.WCMain;
public class CheckWBtnHandler implements View.OnClickListener{
    // Fields
    private String cityName;
    private WAppSearchPgMain wAppSearchPgMain;
    private Handler handler=new Handler();
    // Constructor
    public CheckWBtnHandler(WAppSearchPgMain wAppSearchPgMain){
        this.wAppSearchPgMain = wAppSearchPgMain;
    }
    // Methods
    @Override
    public void onClick(View view){
        this.cityName=this.wAppSearchPgMain.waSPViews.textField.getText().toString();
        if (cityName.isBlank()) this.onError();
        else this.performActions();
    }
    private void performActions(){
        WDHolder.getWdHolder().setFeatureDataClassesArr(new ArrayList<>());
        WCMain wcMain=new WCMain();
        try {
            wcMain.WCMainMethod(this.cityName);
        } catch(Exception e){
            this.onError();
            return;
        }
        this.waitSomeTimeAndCheckResult();
    }
    private void waitSomeTimeAndCheckResult(){
        int initialCount = 10;
        this.makeWaitTimeTvVisibleAndInVisible(View.VISIBLE);
        this.handler.removeCallbacksAndMessages(null);
        this.updateCountAndTextView(initialCount);
    }
    private void updateCountAndTextView(int count){
        this.wAppSearchPgMain.waSPViews.waitTimeTv.setText("Showing in " + count+"s");
        if (count >= 0) {
            this.handler.postDelayed(() -> updateCountAndTextView(count - 1),1000);
        } else {
            this.checkingIt();
        }
    }
    private void checkingIt(){
        if (WDHolder.getWdHolder().getCurrentWeatherData()==null) this.onError();
        else this.ifWDHolderIsNotNull();
        this.makeWaitTimeTvVisibleAndInVisible(View.INVISIBLE);
    }
    private void makeWaitTimeTvVisibleAndInVisible(int visibility){
        this.wAppSearchPgMain.waSPViews.waitTimeTv.setVisibility(visibility);
    }
    private void ifWDHolderIsNotNull(){
        WDHolder.getWdHolder().setIfAllowedToSetData(true);
        this.wAppSearchPgMain.finish();
    }
    private void onError(){
        this.wAppSearchPgMain.waSPViews.textField.setText(null);
        this.wAppSearchPgMain.waSPViews.textField.setHint("Invalid city or weak internet");
    }
}