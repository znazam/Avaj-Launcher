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
                    Methods.SimTxt("JetPlane " + name + " Clear Skies Ahead.hold onto your seatbelts.\n");
                    break;
                case "RAIN":
                    this.coordinates.latitude += 5;
                    Methods.SimTxt("JetPlane " + name + " get your umbrella out, we have leaks\n");
                    break;
                case "FOG":
                    this.coordinates.latitude += 1;
                    Methods.SimTxt("JetPlane " + name + " Fog, watch out for jumping cows and sheep.!\n");
                    break;
                case "SNOW":
                    this.coordinates.height -= 7;
                    Methods.SimTxt("JetPlane " + name + " Snow, up for a slide down a mountain.\n");
                    if (this.coordinates.height < 1){
                        this.coordinates.height = 0;
                        Methods.SimTxt("JetPlane " + name + " Landing.\n");
                        Methods.SimTxt("JetPlane " + name + " landed and unregistered");
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