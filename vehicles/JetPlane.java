package vehicles;

import classes.*;
import interfaces.*;
import functions.*;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    @Override
    public void updateConditions() {
        try {
            String weather = weatherTower.getWeather(this.coordinates);
            switch (weather) {
                case "SUN":
                    this.coordinates.latitude += 10;
                    if ((this.coordinates.height += 2) > 100){
                        this.coordinates.height = 100;
                    }
                    Var.log.add("JetPlane#"+name+"("+this.id+")"+" Clear Skies Ahead.hold onto your seatbelts.\n");
                    break;
                case "RAIN":
                    this.coordinates.latitude += 5;
                    Var.log.add("JetPlane#"+name+"("+this.id+")"+" get your umbrella out, we have leaks\n");
                    break;
                case "FOG":
                    this.coordinates.latitude += 1;
                    Var.log.add("JetPlane#"+name+"("+this.id+")"+" Fog, watch out for jumping cows and sheep.!\n");
                    break;
                case "SNOW":
                    this.coordinates.height -= 7;
                    Var.log.add("JetPlane#"+name+"("+this.id+")"+" Snow, anyone up for a slide down a mountain.\n");
                    if (this.coordinates.height < 1){
                        this.coordinates.height = 0;
                        Var.log.add("Tower says: JetPlane#"+name+"("+this.id+")"+" Landing.\n");
                        Var.log.add("Tower says: JetPlane#"+name+"("+this.id+")"+" landed and unregistered\n");
                        Var.unregister = this;
                        break;
                    }
                    break;
            }
        } catch(Exception e){
            System.out.printf("JetPlane.updateConditions failed");
        }
    }
}