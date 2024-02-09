package life.homail.weatherapp.MainApp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import life.homail.weatherapp.R;
import life.homail.weatherapp.SearchPage.WAppSearchPgMain;

public class WAppHomeViews {
    // Fields
    protected Button searchBtn;
    // TextViews
    protected TextView minTempTv;
    protected TextView maxTempTv;
    protected TextView cityNameTv;
    protected TextView feelsLikeTv;
    protected TextView actualTempTv;
    // Main Activity
    private WeatherAppHomePage weatherAppHomePage;
    // Constructor
    public WAppHomeViews(WeatherAppHomePage weatherAppHomePage) {
        this.weatherAppHomePage = weatherAppHomePage;
        this.thingsToDoWhenConstrcutorIsInvoked();
    }
    // Methods
    private void thingsToDoWhenConstrcutorIsInvoked(){
        this.initializeTextViews();
        this.initializeAndSetHandlerForSearchBtn();
    }
    private void initializeTextViews(){
        this.minTempTv=this.weatherAppHomePage.findViewById(R.id.minTempTv);
        this.maxTempTv=this.weatherAppHomePage.findViewById(R.id.maxTempTv);
        this.cityNameTv=this.weatherAppHomePage.findViewById(R.id.cityNameTv);
        this.feelsLikeTv=this.weatherAppHomePage.findViewById(R.id.feelsLikeTv);
        this.actualTempTv=this.weatherAppHomePage.findViewById(R.id.actualTempTv);
    }
    private void initializeAndSetHandlerForSearchBtn(){
        this.searchBtn=this.weatherAppHomePage.findViewById(R.id.searchBtn);
        this.searchBtn.setOnClickListener(this::searchBtnHandler);
    }



    // Handling search btn events here but i'd say create a separate file in feature
    private void searchBtnHandler(View view){
        Intent intent=new Intent(this.weatherAppHomePage, WAppSearchPgMain.class);
        this.weatherAppHomePage.startActivity(intent);
    }
}
