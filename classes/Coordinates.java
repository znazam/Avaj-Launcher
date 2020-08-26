package classes;

public class Coordinates{
    public int longitude;
    public int latitude;
    public int height;
    
    public Coordinates(int longitude, int latitude, int height){
        System.out.println("called coordinates constructor");
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude(){
        return this.longitude;
    }

    public int getLatitude(){
        return this.latitude;
    }

    public int getHeight(){
        return this.height;
    }
}