package MinecraftHaven;

/**
 * Created by Peter on 19-5-2015.
 */
public class Object {
    private Double lat;
    private Double lon;

    private int x;
    private int z;

    private int type;

    public Object(int type, Double lat, Double lon, int x, int z){
        this.type = type;
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

    public int getType() {
        return type;
    }
}
