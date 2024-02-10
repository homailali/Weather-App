package life.homail.weatherapp.WDPlusWDHolder;

public class FeatureDataClass{
    // Fields
    private String dayDate;
    private String dayTemp;
    private String dayTime;

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    // Constructor
    public FeatureDataClass(String dayDate,  String dayTime,String dayTemp) {
        this.dayDate = dayDate;
        this.dayTemp = dayTemp;
        this.dayTime = dayTime;
    }


    // Methods
    public String getDayDate() {
        return dayDate;
    }

    public void setDayDate(String dayDate) {
        this.dayDate = dayDate;
    }

    public String getDayTemp() {
        return dayTemp;
    }

    public void setDayTemp(String dayTemp) {
        this.dayTemp = dayTemp;
    }
}