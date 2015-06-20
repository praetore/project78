package handler;

import handler.coordinates.Coordinate;
import handler.exporter.IExporter;
import handler.exporter.SiloCoordinatesExport;

import java.util.List;

import static handler.Const.EXPORT_PATH;
import static handler.Const.SILO_COORDS_IMPORT_PATH;

/**
 * Created by darryl on 20-6-15.
 */
public class RunSiloExport {
    public static void main(String[] args) {
        IExporter reader = new SiloCoordinatesExport(EXPORT_PATH, SILO_COORDS_IMPORT_PATH);
        List<Coordinate> coordinates = reader.readData();
        reader.exportData(coordinates);
    }
}
