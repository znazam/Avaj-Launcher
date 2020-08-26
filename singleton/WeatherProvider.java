package singleton;

import java.util.*;
import classes.Coordinates;

public class WeatherProvider {

    public static WeatherProvider weatherProvider = null;
    private static String[] weather = {"SUN","RAIN", "FOG", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider(){
        System.out.println("called weather provider constructor");
        if (weatherProvider == null)
        {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        System.out.println("called get current weather");
        Random random = new Random();
        // String wea;
        // String h = this.coordinates.Height;
        // if (h <= 25 && h >= 0){
        //     wea = weather[random.nextInt(4)];
        //     System.out.println(wea);
        //     return wea;
        // }
        // if (h >= 26 && h <= 50){
        //     wea = weather[random.nextInt(3)];
        //     System.out.println(wea);
        //     return wea;
        // }
        // if (h >= 51 && h <= 75){
        //     wea = weather[random.nextInt(2)];
        //     System.out.println(wea);
        //     return wea;
        // }
        //if (h >= 76 && h <= 100){
        return weather[random.nextInt(4)];
        //}
    }   
}