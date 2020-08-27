package classes;

import interfaces.*;
import java.util.*;
import functions.Var;

public class Tower {

    public ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        try {
            this.observers.add(flyable);
            flyable.registerTower((WeatherTower)this);
        } catch (Exception e) {
            System.out.println("tower.register failed");
        }
    }

    public void unregister(Flyable flyable){
        try {
            this.observers.remove(flyable);
        } catch (Exception e) {
            System.out.println("unregister didn't work");
        }
    }

    public void conditionsChanged(){
        try {
            if (observers.contains(Var.unregister)){
                unregister(Var.unregister);
            }
            for(Flyable flyable : this.observers){
                try {
                    flyable.updateConditions();
                } catch (Exception e) {
                    System.out.println("failed to update the conditions in tower");
                }
           }
        } catch (Exception e) {
            System.out.println("conditions didn't change when trying to unregister aircraft in tower");
        }
    }
    
}