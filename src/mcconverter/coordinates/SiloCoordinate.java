package mcconverter.coordinates;

/**
 * Created by darryl on 20-6-15.
 */
public class SiloCoordinate extends Coordinate {
    final private String schematic;

    public SiloCoordinate(Double lat, Double lon, int x, int z, String schematic) {
        super(lat, lon, x, z);
        this.schematic = schematic;
    }

    public String getSchematic() {
        return schematic;
    }

    @Override
    public String toString() {
        return schematic + "," + lat + "," + lon + "," + x + "," + z;
    }
}