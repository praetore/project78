package handler.coordinates;

/**
 * Created by darryl on 20-6-15.
 */
public class MapCoordinate extends Coordinate {
    final private int type;

    public MapCoordinate(int type, Double lat, Double lon, int x, int z) {
        super(lat, lon, x, z);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + "," + lat + "," + lon + "," + x + "," + z;
    }
}
