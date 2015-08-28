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

    Double NORTH = 52.0123191;
    Double EAST = 4.27192867;
    Double SOUTH = 51.8738462;
    Double WEST = 3.98795229;
}