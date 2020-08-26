package classes;
import interfaces.*;
import java.util.*;

import functions.Var;

public abstract class Tower {

    private ArrayList<Flyable> obsevers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        try {
            this.obsevers.add(flyable);
            flyable.registerTower((WeatherTower)this);
        } catch (Exception e) {
            System.out.println("tower.register failed");
        }
    }

    public void unregister(Flyable flyable){
        try {
            this.obsevers.remove(flyable);
        } catch (Exception e) {
            System.out.println("unregister didn't work");
        }
    }

    protected void conditionsChanged(){
        try {
            if (obsevers.contains(Var.unregister)){
                unregister(Var.unregister);
            }
            for (Flyable flyable : obsevers){
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