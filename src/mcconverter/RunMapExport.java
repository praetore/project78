package mcconverter;

import mcconverter.coordinates.Coordinate;
import mcconverter.exporter.Exporter;
import mcconverter.exporter.MapCoordinatesExport;

import java.util.List;

import static mcconverter.Const.EXPORT_PATH;
import static mcconverter.Const.MAP_COORDS_IMPORT_PATH;

/**
 * Created by darryl on 20-6-15.
 */
public class RunMapExport {
    public static void main(String[] args) {
        Exporter reader = new MapCoordinatesExport(EXPORT_PATH, MAP_COORDS_IMPORT_PATH);
        List<Coordinate> coordinates = reader.readData();
        reader.exportData(coordinates);
    }
}