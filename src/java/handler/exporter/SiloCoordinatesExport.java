package handler.exporter;

import handler.coordinates.Coordinate;
import handler.coordinates.SiloCoordinate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darryl on 20-6-15.
 */
public class SiloCoordinatesExport extends Exporter implements IExporter {
    public SiloCoordinatesExport(String exportPath, String importPath) {
        super(exportPath, importPath);
    }

    @Override
    public List<Coordinate> readData() {
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(importPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            CoordinateCalculator cal = new CoordinateCalculator();

            while (reader.ready()) {
                String text = reader.readLine();
                String[] split = text.split(",");
                Double lat = Double.parseDouble(split[1]);
                Double lng = Double.parseDouble(split[2]);
                String schematic = split[3];

                if (cal.inRegion(lat, lng)) {
                    int x = cal.getXfromCor(lat);
                    int z = cal.getZfromCor(lng);
                    SiloCoordinate res = new SiloCoordinate(lat, lng, x, z, schematic);
                    System.out.println(res);
                    coordinates.add(res);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coordinates;
    }
}
