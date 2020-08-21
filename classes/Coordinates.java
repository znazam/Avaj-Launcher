package classes;

public class Coordinates{
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public getLongitude(){
        return this.longitude;
    }

    public getLatitude(){
        return this.latitude;
    }

    public getHeight(){
        return this.height;
    }
}