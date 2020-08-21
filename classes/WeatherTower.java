package classes;

import singleton.*;

public class WeatherTower {
    
    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
}