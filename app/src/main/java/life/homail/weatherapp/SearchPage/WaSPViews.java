package life.homail.weatherapp.SearchPage;
import android.widget.Button;
import android.widget.TextView;

import life.homail.weatherapp.R;
import com.google.android.material.textfield.TextInputEditText;
public class WaSPViews {
    // Fields
    protected WAppSearchPgMain wAppSearchPgMain;
    protected TextInputEditText textField;
    protected Button goBackBtn;
    protected Button checkWeatherBtn;
    protected TextView waitTimeTv;
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
        this.textField.addTextChangedListener(this.wAppSearchPgMain.textFieldHandler);
    }
    private void initializeViews(){
        this.waitTimeTv=this.wAppSearchPgMain.findViewById(R.id.waitTimeTv);
        this.textField=this.wAppSearchPgMain.findViewById(R.id.textField);
        this.goBackBtn=this.wAppSearchPgMain.findViewById(R.id.goBackBtn);
        this.checkWeatherBtn=this.wAppSearchPgMain.findViewById(R.id.checkWeatherBtn);
    }
    // Some Settings here
    private void setHintForTextField(){
        this.textField.setHint("Enter city name");
    }
}
