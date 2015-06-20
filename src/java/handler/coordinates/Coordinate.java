package handler.coordinates;

/**
 * Created by Peter on 19-5-2015.
 */
public abstract class Coordinate {
    final protected Double lat;
    final protected Double lon;
    final protected int x;
    final protected int z;

    public Coordinate(Double lat, Double lon, int x, int z){
        this.lat = lat;
        this.lon = lon;
        this.x = x;
        this.z = z;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

}
