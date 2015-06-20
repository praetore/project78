package handler.exporter;

import handler.coordinates.Coordinate;
import handler.coordinates.MapCoordinate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Peter on 19-5-2015.
 */
public class MapCoordinatesExport extends Exporter implements IExporter {
    public MapCoordinatesExport(String exportPath, String importPath) {
        super(exportPath, importPath);
    }

    public List<Coordinate> readData() {
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        String nameRegex = "(.+);.+;.+;.+;(.+);(.+)";
        Pattern pattern = Pattern.compile(nameRegex);
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(importPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            CoordinateCalculator cal = new CoordinateCalculator();
            String text;

            while ((text = reader.readLine()) != null) {
                Matcher m = pattern.matcher(text);
                if (m.find()) {
                    int type = Integer.parseInt(m.group(1));
                    Double lat = Double.parseDouble(m.group(2));
                    Double lng = Double.parseDouble(m.group(3));

                    if (cal.inRegion(lat, lng)) {
                        int x = cal.getXfromCor(lat);
                        int z = cal.getZfromCor(lng);
                        coordinates.add(new MapCoordinate(type, lat, lng, x, z));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coordinates;
    }
}
