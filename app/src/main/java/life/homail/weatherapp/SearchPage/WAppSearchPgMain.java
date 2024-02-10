package life.homail.weatherapp.SearchPage;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import life.homail.weatherapp.R;
import androidx.appcompat.app.AppCompatActivity;
public class WAppSearchPgMain extends AppCompatActivity{
    // Fields
    protected WaSPViews waSPViews;
    protected TextFieldHandler textFieldHandler=new TextFieldHandler(this);
    protected GoBackBtnHandler goBackBtnHandler=new GoBackBtnHandler(this);
    protected CheckWBtnHandler checkWBtnHandler=new CheckWBtnHandler(this);
    // Methods
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.weather_app_search_page_activity);
        this.changeStatusBarColor();
        this.waViewsObjSettings();
    }






    private void waViewsObjSettings(){
        this.waSPViews=new WaSPViews(this);
    }



    private void changeStatusBarColor(){
        Window window=super.getWindow();
        window.setStatusBarColor(Color.WHITE);
    }
}
