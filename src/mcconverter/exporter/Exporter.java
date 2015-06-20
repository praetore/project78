package mcconverter.exporter;

import mcconverter.coordinates.Coordinate;

import java.util.List;

/**
 * Created by darryl on 20-6-15.
 */
public interface Exporter {
    List<Coordinate> readData();
    void exportData(List<Coordinate> coordinates);
}