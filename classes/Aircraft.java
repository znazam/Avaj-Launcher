package classes;

public abstract class Aircraft{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    public Aircraft(String name, Coordinates coordinates){
        System.out.println("called aircraft contructor");
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId(){
        return idCounter++;
    }
}