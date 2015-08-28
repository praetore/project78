package mcconverter;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by darryl on 20-6-15.
 */
public interface Const {
    String SILO_COORDS_IMPORT_PATH = "/points.csv";
    Path EXPORT_PATH = Paths.get("out", "points.csv");

    int IMAGE_WIDTH = 10230;
    int IMAGE_HEIGHT = 6448;

    Double NORTH = 51.9269342;
    Double EAST = 4.52432307;
    Double SOUTH = 51.8694727;
    Double WEST = 4.37458349;
}
