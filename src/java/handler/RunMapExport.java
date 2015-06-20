package handler;

import handler.coordinates.Coordinate;
import handler.exporter.IExporter;
import handler.exporter.MapCoordinatesExport;

import java.util.List;

import static handler.Const.EXPORT_PATH;
import static handler.Const.MAP_COORDS_IMPORT_PATH;

/**
 * Created by darryl on 20-6-15.
 */
public class RunMapExport {
    public static void main(String[] args) {
        IExporter reader = new MapCoordinatesExport(EXPORT_PATH, MAP_COORDS_IMPORT_PATH);
        List<Coordinate> coordinates = reader.readData();
        reader.exportData(coordinates);
    }
}
