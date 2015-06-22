package mcconverter;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by darryl on 20-6-15.
 */
public interface Const {
    String MAP_COORDS_IMPORT_PATH = "/data.csv";
    String SILO_COORDS_IMPORT_PATH = "/silos.csv";
    Path EXPORT_PATH = Paths.get("out", "out.txt");

    int IMAGE_WIDTH = 7680;
    int IMAGE_HEIGHT = 6144;

    Double NORTH = 52.0123191;
    Double EAST = 4.27192867;
    Double SOUTH = 51.8738462;
    Double WEST = 3.98795229;
}