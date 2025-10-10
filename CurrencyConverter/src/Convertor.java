import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Convertor {
    public double convert(String ctry1,String ctry2,double amt){
        String country1=currency(ctry1);
        String country2=currency(ctry2);
        if(country1.isEmpty() || country2.isEmpty()) {
            System.out.println("Invalid country name entered!");
            return 0.0;
        }
        try {
            String encodedCountry = URLEncoder.encode(country1, "UTF-8");
            URL url=new URL("https://api.exchangerate-api.com/v4/latest/" + encodedCountry);
           HttpURLConnection con=(HttpURLConnection) url.openConnection();
           BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
           String input;
           StringBuilder response=new StringBuilder();
           while ((input=reader.readLine())!=null){
               response.append(input);
           }
           JSONObject json=new JSONObject(response.toString());
           JSONObject rate=json.getJSONObject("rates");
           double total=rate.getDouble(country2);
           return total*amt;

       }catch (Exception e){
        }
       return 0.0;
    }
    public String currency(String ctry){
        try {
            String encodedCountry = URLEncoder.encode(ctry, "UTF-8");
            URL url=new URL("https://restcountries.com/v3.1/name/"+encodedCountry);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            StringBuilder response=new StringBuilder();
            while ((input=reader.readLine())!=null){
                response.append(input);
            }
            JSONArray arr = new JSONArray(response.toString());
            JSONObject json = arr.getJSONObject(0);

            JSONObject curr=json.getJSONObject("currencies");
            String code = curr.keys().next();
            return code;

        } catch (Exception e) {
    }
        return "";
    }
}
