package vehicles;

import classes.*;
import interfaces.*;
import functions.*;

public class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
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
                    this.coordinates.height += 4;
                    if (this.coordinates.height > 100){
                        this.coordinates.height = 100;
                    }
                    this.coordinates.longitude += 2;
                    Var.log.add("Baloon#"+name+"("+this.id+")"+" ahhh nice and warm, who has an ice cream\n");
                    break;
                case "RAIN":
                    this.coordinates.height -= 5;
                    Var.log.add("Baloon#"+name+"("+this.id+")"+" damn its raining, I hope you brought a jacket\n");
                    if (this.coordinates.height < 1){
                        this.coordinates.height = 0;
                        Var.log.add("Baloon#"+name+"("+this.id+")"+" Landing.\n");
                        Var.log.add("Baloon#"+name+"("+this.id+")"+" landed and unregistered from tower\n");
                        Var.unregister = this;
                        break;
                    }
                    break;
                case "FOG":
                    this.coordinates.height -= 3;
                    Var.log.add("Baloon#"+name+"("+this.id+")"+" i can't see a thing because of this fog, who stole my sandwich\n");
                    if (this.coordinates.height < 1){
                        this.coordinates.height = 0;
                        Var.log.add("Tower says: Baloon#"+name+"("+this.id+")"+" Landing.\n");
                        Var.log.add("Tower says: Baloon#"+name+"("+this.id+")"+" has landed and unregistered from tower\n");
                        Var.unregister = this;
                        break;
                    }
                    break;
                case "SNOW":
                    this.coordinates.height -= 15;
                    Var.log.add("Baloon#"+name+"("+this.id+")"+" I see snow, where's my teddy, I need a cuddle\n");
                    if (this.coordinates.height < 1){
                        this.coordinates.height = 0;
                        Var.log.add("Tower says: Baloon#"+name+"("+this.id+")"+" Landing.\n");
                        Var.log.add("Tower says: Baloon#"+name+"("+this.id+")"+" has landed and is unregistered from tower\n");
                        Var.unregister = this;
                        break;
                    }
                    break;
            }
        } catch(Exception e){
            System.out.printf("Baloon.updateConditions failed");
        }
    }
}