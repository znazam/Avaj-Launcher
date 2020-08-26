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
        System.out.println("called baloon update conditions");
        try {
            String weather = weatherTower.getWeather(this.coordinates);
            switch (weather) {
                case "SUN":
                    this.coordinates.height += 4;
                    if (this.coordinates.height > 100){
                        this.coordinates.height = 100;
                    }
                    this.coordinates.longitude += 2;
                    //Methods.SimTxt("Baloon "+name+" ahhh nice and warm, who has an ice cream\n");
                    Var.log.add("Baloon "+name+" ahhh nice and warm, who has an ice cream\n");
                    break;
                case "RAIN":
                    this.coordinates.height -= 5;
                    //Methods.SimTxt("Baloon "+name+" damn its raining, I hope you brought a jacket\n");
                    Var.log.add("Baloon "+name+" damn its raining, I hope you brought a jacket\n");
                    if (this.coordinates.height < 1){
                        this.coordinates.height = 0;
                        //Methods.SimTxt("Baloon "+name+" Landing.\n");
                        Var.log.add("Baloon "+name+" Landing.\n");
                        //Methods.SimTxt("Baloon "+name+" landed and unregistered from tower\n");
                        Var.log.add("Baloon "+name+" landed and unregistered from tower\n");
                        Var.unregister = this;
                        break;
                    }
                    break;
                case "FOG":
                    this.coordinates.height -= 3;
                    //Methods.SimTxt("Baloon "+name+" i can't see a thing because of this fog, who stole my sandwich\n");
                    Var.log.add("Baloon "+name+" i can't see a thing because of this fog, who stole my sandwich\n");
                    if (this.coordinates.height < 1){
                        this.coordinates.height = 0;
                        //Methods.SimTxt("Baloon "+name+" Landing.\n");
                        Var.log.add("Baloon "+name+" Landing.\n");
                        //Methods.SimTxt("Baloon "+name+" has landed and unregistered from tower\n");
                        Var.log.add("Baloon "+name+" has landed and unregistered from tower\n");
                        Var.unregister = this;
                        break;
                    }
                    break;
                case "SNOW":
                    this.coordinates.height -= 15;
                    // Methods.SimTxt("Baloon "+name+" I see snow, where's my teddy, I need a cuddle\n");
                    Var.log.add("Baloon "+name+" I see snow, where's my teddy, I need a cuddle\n");
                    if (this.coordinates.height < 1){
                        this.coordinates.height = 0;
                        // Methods.SimTxt("Baloon "+name+" Landing.\n");
                        Var.log.add("Baloon "+name+" Landing.\n");
                        // Methods.SimTxt("Baloon "+name+" has landed and is unregistered from tower\n");
                        Var.log.add("Baloon "+name+" has landed and is unregistered from tower\n");
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