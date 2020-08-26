package vehicles;

import classes.Coordinates;
import interfaces.*;
import functions.*;

public abstract class AircraftFactory {
    
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        try{
            Flyable flyable;
            Coordinates coordinates = new Coordinates(longitude, latitude, height);
            switch(type){
                case "Baloon":
                flyable = new Baloon(name, coordinates);
                break;
                case "Helicopter":
                flyable = new Helicopter(name,coordinates);
                break;
                case "JetPlane":
                flyable = new JetPlane(name,coordinates);
                break;
                default:
                throw new IllegalStateException("Type not recognized " + type);
            }
            Methods.SimTxt(type + " " + name);
            return flyable;
        }
        catch(Exception e){
            System.out.println("error with data recieved for simulation");
            return null;
        }
    }
    
}