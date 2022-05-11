package edu.umb.cs681.hw10;
import java.util.ArrayList;

public final class Position {
    private final double longitude;
    private final double altitude;
    private final double latitude;


    public Position(double lat, double lon, double alt) {
        this.latitude = lat;
        this.longitude = lon;
        this.altitude = alt;
    }
    public double getLongitude() {
        return this.longitude;
    }

    public double getAltitude() {
        return this.altitude;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public String toString(){
        return longitude + "-" + altitude+ "-" + latitude;
    }
    public boolean equals(Position anotherposition) {
        if(this.toString().equals(anotherposition.toString())) {return true;}
        else {return false;}

    }
    public ArrayList<Double> getCoordinate() {
        ArrayList<Double> coordinates = new ArrayList<>();
        coordinates.add(latitude);
        coordinates.add(longitude);
        coordinates.add(altitude);
        return coordinates;
    }

    public Position changeLat(double newLat) {
        return new Position(newLat, this.longitude, this.altitude);
    }

    public Position changeLong(double newLong) {
        return new Position(this.latitude, newLong, this.altitude);
    }

    public Position changeAlt(double newAlt) {
        return new Position(this.latitude, this.longitude, newAlt);
    }

}
