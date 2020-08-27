package classes;

import functions.*;

public abstract class Aircraft{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    public Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        Var.ID = this.id = nextId();
    }

    private long nextId(){
        return idCounter++;
    }
}