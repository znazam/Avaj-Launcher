package classes;

import interfaces.*;
import java.util.*;
import functions.Var;
import vehicles.*;

public class Tower {

    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        System.out.println("called register constructor");
        try {
            this.observers.add(flyable);
            flyable.registerTower((WeatherTower)this);
        } catch (Exception e) {
            System.out.println("tower.register failed");
        }
    }

    public void unregister(Flyable flyable){
        System.out.println("called unregister");
        try {
            this.observers.remove(flyable);
        } catch (Exception e) {
            System.out.println("unregister didn't work");
        }
    }

    public void conditionsChanged(){
        System.out.println("called conditionschanged");
        try {
            if (observers.contains(Var.unregister)){
                unregister(Var.unregister);
            }
            for (Flyable flyable : observers){
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