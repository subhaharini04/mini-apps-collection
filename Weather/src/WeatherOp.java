import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;


public class WeatherOp {
    String key = System.getenv("WEATHER_API_KEY");
    public void view(String place) {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + place + "&appid=" + key + "&units=metric");
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            BufferedReader reader =new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            StringBuilder response=new StringBuilder();
            while ((input=reader.readLine())!=null){
                response.append(input);
            }
            JSONObject json =new JSONObject(response.toString());

            JSONObject coord=json.getJSONObject("coord");
            double lon=coord.getDouble("lon");
            double lat = coord.getDouble("lat");

            JSONArray weather=json.getJSONArray("weather");
            JSONObject first=weather.getJSONObject(0);
            String climate=first.getString("main");
            String des= first.getString("description");

            JSONObject places=json.getJSONObject("sys");
            String country= places.getString("country");

            JSONObject main=json.getJSONObject("main");
            double temp= main.getDouble("temp");
            int humidity= main.getInt("humidity");
            double feelsLike=main.getDouble("feels_like");

            JSONObject wind=json.getJSONObject("wind");
            double windSpeed=wind.getDouble("speed");

            System.out.println("📍 Location: " + place + ", " + country);
            System.out.println("🧭 Coordinates: " + lat + "°N, " + lon + "°E");
            System.out.println("🌤 Weather: " + climate + " (" + des + ")");
            System.out.println("🌡 Temperature: " + temp + "°C (Feels like " + feelsLike + "°C)");
            System.out.println("💧 Humidity: " + humidity + "%");
            System.out.println("🌬 Wind Speed: " + windSpeed + " m/s");

        }catch (Exception e){
            System.out.println("Sorry, We not Found your Location!");
        }
    }
}
