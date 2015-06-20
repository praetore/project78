package handler.exporter;

import handler.coordinates.Coordinate;

import java.util.List;

/**
 * Created by darryl on 20-6-15.
 */
public interface IExporter {
    List<Coordinate> readData();
    void exportData(List<Coordinate> coordinates);
}
