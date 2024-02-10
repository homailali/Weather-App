package life.homail.weatherapp.HomePage;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import life.homail.weatherapp.R;
import life.homail.weatherapp.SearchPage.WAppSearchPgMain;
public class WAppHomeViews{
    // Fields
    protected Button searchBtn;
    // TextViews
    protected TextView minTempTv;
    protected TextView maxTempTv;
    protected TextView cityNameTv;
    protected TextView feelsLikeTv;
    protected TextView actualTempTv;
    // Rc View
    protected RecyclerView rcView;
    // Main Activity
    private WAHomePageMain WAHomePageMain;
    // Constructor
    public WAppHomeViews(WAHomePageMain WAHomePageMain) {
        this.WAHomePageMain = WAHomePageMain;
        this.thingsToDoWhenConstrcutorIsInvoked();
    }
    // Methods
    private void thingsToDoWhenConstrcutorIsInvoked(){
        this.initializeRcView();
        this.initializeTextViews();
        this.initializeAndSetHandlerForSearchBtn();
    }
    private void initializeTextViews(){
        this.minTempTv=this.WAHomePageMain.findViewById(R.id.minTempTv);
        this.maxTempTv=this.WAHomePageMain.findViewById(R.id.maxTempTv);
        this.cityNameTv=this.WAHomePageMain.findViewById(R.id.cityNameTv);
        this.feelsLikeTv=this.WAHomePageMain.findViewById(R.id.feelsLikeTv);
        this.actualTempTv=this.WAHomePageMain.findViewById(R.id.actualTempTv);
    }
    private void initializeRcView(){
        this.rcView=this.WAHomePageMain.findViewById(R.id.rcView);
    }
    private void initializeAndSetHandlerForSearchBtn(){
        this.searchBtn=this.WAHomePageMain.findViewById(R.id.searchBtn);
        this.searchBtn.setOnClickListener(this::searchBtnHandler);
    }
    // Handling search btn events here but i'd say create a separate file in feature
    private void searchBtnHandler(View view){
        Intent intent=new Intent(this.WAHomePageMain, WAppSearchPgMain.class);
        this.WAHomePageMain.startActivity(intent);
    }
}