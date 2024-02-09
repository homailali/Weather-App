package life.homail.weatherapp.WeatherCalculator;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class NetworkUtils {
    public static String makeRequest(URL url) throws Exception{
        HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
        InputStream inputStream=httpURLConnection.getInputStream();
        try {
            Scanner scanner=new Scanner(inputStream);
            scanner.useDelimiter("\\A");
            if (scanner.hasNext()) return scanner.next();
        } catch (Exception exception){}
        httpURLConnection.disconnect();
        return null;
    }
}
