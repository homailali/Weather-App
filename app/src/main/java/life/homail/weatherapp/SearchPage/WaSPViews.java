package life.homail.weatherapp.SearchPage;
import android.widget.Button;

import life.homail.weatherapp.R;
import com.google.android.material.textfield.TextInputEditText;
public class WaSPViews {
    // Fields
    protected WAppSearchPgMain wAppSearchPgMain;
    protected TextInputEditText textField;
    protected Button goBackBtn;
    protected Button checkWeatherBtn;
    // Constructor
    public WaSPViews(WAppSearchPgMain wAppSearchPgMain) {
        this.wAppSearchPgMain = wAppSearchPgMain;
        this.afterConstructorCallDo();
    }
    // Methods
    private void afterConstructorCallDo(){
        this.initializeViews();
        this.setHintForTextField();
        this.setEventHandlers();
    }




    private void setEventHandlers(){
        this.goBackBtn.setOnClickListener(this.wAppSearchPgMain.goBackBtnHandler);
        this.checkWeatherBtn.setOnClickListener(this.wAppSearchPgMain.checkWBtnHandler);
    }

    private void initializeViews(){
        this.textField=this.wAppSearchPgMain.findViewById(R.id.textField);
        this.goBackBtn=this.wAppSearchPgMain.findViewById(R.id.goBackBtn);
        this.checkWeatherBtn=this.wAppSearchPgMain.findViewById(R.id.checkWeatherBtn);
    }
    // Some Settings here
    private void setHintForTextField(){
        this.textField.setHint("Enter city name");
    }
}
