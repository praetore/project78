package mcconverter.coordinates;

/**
 * Created by darryl on 20-6-15.
 */
public class SiloCoordinate extends Coordinate {
    final private String schematic;
    final private String direction;

    public SiloCoordinate(Double lat, Double lon, int x, int z, String schematic, String direction) {
        super(lat, lon, x, z);
        this.schematic = schematic;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return schematic + "," + lat + "," + lon + "," + x + "," + z + "," + direction;
    }
}