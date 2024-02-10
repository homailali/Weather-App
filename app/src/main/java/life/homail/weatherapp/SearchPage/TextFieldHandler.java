package life.homail.weatherapp.SearchPage;

import android.text.Editable;
import android.text.TextWatcher;

public class TextFieldHandler implements TextWatcher{
    // Fields
    private WAppSearchPgMain wAppSearchPgMain;
    // Constructor
    public TextFieldHandler(WAppSearchPgMain wAppSearchPgMain) {
        this.wAppSearchPgMain = wAppSearchPgMain;
    }
    // Methods
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}
    @Override
    public void afterTextChanged(Editable editable){
        if (editable.toString().isEmpty()){
            this.wAppSearchPgMain.waSPViews.textField.setHint("Enter city name");
        }
    }
}
