package handler.exporter;

import handler.coordinates.Coordinate;

import java.io.*;
import java.util.List;

/**
 * Created by darryl on 20-6-15.
 */
abstract class Exporter {
    protected final String exportPath;
    protected final String importPath;

    public Exporter(String exportPath, String importPath) {
        this.exportPath = exportPath;
        this.importPath = importPath;
    }

    public void exportData(List<Coordinate> coordinates) {
        File output = new File(exportPath);
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
}
