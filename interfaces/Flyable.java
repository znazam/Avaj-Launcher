package interfaces;
import classes.WeatherTower;

//System.out.println("called interfaces");
public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower WeatherTower);
}