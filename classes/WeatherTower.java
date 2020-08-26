package classes;

import singleton.*;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates){
        System.out.println("called get weather");
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
}