package vehicles;

import classes.*;
import interfaces.*;
import functions.*;

public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower weatherTower;
    
    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    
    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
    }
    @Override
    public void updateConditions() {
        System.out.println("called helicopter update conditions");
        try {
            String weather = weatherTower.getWeather(this.coordinates);
            switch (weather) {
                case "SUN":
                    this.coordinates.longitude += 10;
                    if ((this.coordinates.height += 2) > 100){
                        this.coordinates.height = 100;
                    }
                    // Methods.SimTxt("Helicopter "+name+" Sunny day, sit back and enjoy the ride\n");
                    Var.log.add("Helicopter "+name+" Sunny day, sit back and enjoy the ride\n");
                    break;
                case "RAIN":
                    this.coordinates.longitude += 5;
                    // Methods.SimTxt("Helicopter "+name+" Damn rain, I hope no ones hair runs home\n");
                    Var.log.add("Helicopter "+name+" Damn rain, I hope no ones hair runs home\n");
                    break;
                case "FOG":
                    this.coordinates.longitude += 1;
                    // Methods.SimTxt("Helicopter "+name+" Lets hope we dont fly into a bird\n");
                    Var.log.add("Helicopter "+name+" Lets hope we dont fly into a bird\n");
                    break;
                case "SNOW":
                    this.coordinates.height -= 12;
                    // Methods.SimTxt("Helicopter "+name+" damn its cold, anyone wanna take the controls while i have a cup of coffee\n");
                    Var.log.add("Helicopter "+name+" damn its cold, anyone wanna take the controls while i have a cup of coffee\n");
                    if (this.coordinates.height < 1){
                        this.coordinates.height = 0;
                        // Methods.SimTxt("Helicopter "+name+" is Landing.\n");
                        Var.log.add("Helicopter "+name+" is Landing.\n");
                        // Methods.SimTxt("Helicopter "+name+" is landed and unregistered from Tower\n");
                        Var.log.add("Helicopter "+name+" is landed and unregistered from Tower\n");
                        Var.unregister = this;
                        break;
                    }
                    break;
            }
        } catch(Exception e){
            System.out.printf("Helicopter update conditions failed");
        }
    }
}