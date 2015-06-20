package handler.exporter;

import static handler.Const.*;

/**
 * Created by Peter on 18-5-2015.
 */
public class CoordinateCalculator {
    private Double xDiffCor;
    private Double zDiffCor;

    public CoordinateCalculator() {
        //Calculate dimensions
        xDiffCor = EAST - WEST;
        zDiffCor = NORTH - SOUTH;
    }

    //Check if coordinates occur in map
    public boolean inRegion(Double x, Double z) {
        return xValid(x) && zValid(z);
    }

    private boolean xValid(Double x) {
        return x <= EAST && x >= WEST;
    }

    public boolean zValid(Double z) {
        return z <= NORTH && z >= SOUTH;
    }

    //Get minecraft X from Latitude
    public int getXfromCor(Double x) {

        //Calculate difference
        Double xDiff = x - WEST;

        //Calculate result
        Double xResult = (xDiff / xDiffCor) * IMAGE_WIDTH;

        return xResult.intValue();
    }

    //Get minecraft Z from longditude
    public int getZfromCor(Double z) {

        //Calculate difference
        Double zDiff = NORTH - z;

        //Calculate result
        Double zResult = (zDiff / zDiffCor) * IMAGE_HEIGHT;

        return zResult.intValue();
    }
}
