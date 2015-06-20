package exporter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static exporter.Const.EXPORT_PATH;
import static exporter.Const.IMPORT_PATH;

/**
 * Created by Peter on 19-5-2015.
 */
public class DataReader {
    public List<Coordinate> readData() {
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        String nameRegex = "(.+);.+;.+;.+;(.+);(.+)";
        Pattern pattern = Pattern.compile(nameRegex);
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(IMPORT_PATH);
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
                        coordinates.add(new Coordinate(type, lat, lng, x, z));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coordinates;
    }

    public void exportData(List<Coordinate> coordinates) {
        File output = new File(EXPORT_PATH);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(output);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (Coordinate coordinate : coordinates) {
                bw.write(coordinate.toString());
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DataReader reader = new DataReader();
        List<Coordinate> coordinates = reader.readData();
        reader.exportData(coordinates);
    }
}
