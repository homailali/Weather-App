package life.homail.weatherapp.HomePage;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import life.homail.weatherapp.R;
import life.homail.weatherapp.WDPlusWDHolder.WDHolder;
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    // Fields
    private WAHomePageMain WAHomePageMain;
    // Constructor
    public Adapter(WAHomePageMain WAHomePageMain) {
        this.WAHomePageMain = WAHomePageMain;
    }
    // Methods
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view= LayoutInflater.from(this.WAHomePageMain).inflate(R.layout.row_design_for_adapter,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.dayDate.setText(WDHolder.getWdHolder().getFeatureDataClassesArr().get(position).getDayDate());
        holder.dayTemp.setText(WDHolder.getWdHolder().getFeatureDataClassesArr().get(position).getDayTemp());
        holder.dayTime.setText(WDHolder.getWdHolder().getFeatureDataClassesArr().get(position).getDayTime());
    }
    @Override
    public int getItemCount() {
        return WDHolder.getWdHolder().getFeatureDataClassesArr().size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView dayDate;
        private TextView dayTemp;
        private TextView dayTime;
        public ViewHolder (View itemView){
            super(itemView);
            this.dayDate=itemView.findViewById(R.id.dayDate);
            this.dayTemp=itemView.findViewById(R.id.dayTemp);
            this.dayTime=itemView.findViewById(R.id.dayTime);
        }
    }
}
