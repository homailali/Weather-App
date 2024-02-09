package life.homail.weatherapp.SearchPage;
import android.view.View;
public class GoBackBtnHandler implements View.OnClickListener{
    // Fields
    private WAppSearchPgMain wAppSearchPgMain;
    // Constructor
    public GoBackBtnHandler(WAppSearchPgMain wAppSearchPgMain) {
        this.wAppSearchPgMain = wAppSearchPgMain;
    }
    // Methods
    @Override
    public void onClick(View view){
        this.wAppSearchPgMain.finish();
    }

}
