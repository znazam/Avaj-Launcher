package singleton;

import java.util.*;
import classes.Coordinates;

public class WeatherProvider {

    public static WeatherProvider weatherProvider = null;
    private static String[] weather = {"SUN","RAIN", "FOG", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider(){
        if (weatherProvider == null)
        {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random random = new Random();
        return weather[random.nextInt(4)];
    }   
}