package MinecraftHaven;

/**
 * Created by Peter on 18-5-2015.
 */
public class CoordinateCalculator {
    private int imageWidth = 2556;
    private int imageHeight = 2048;

    private Double north = 52.0123191;
    private Double east = 4.27192867;
    private Double south = 51.8738462;
    private Double west = 3.98795229;

    private Double widthKM = 19.76;
    private Double heightKM = 15.10;

    private Double xDiffCor;
    private Double zDiffCor;

    private Double xDelta;
    private Double zDelta;


    public static void main(String[]args){
        new CoordinateCalculator();
    }

    public CoordinateCalculator(){

        //Calculate dimensions
        xDiffCor = east - west;
        zDiffCor = north - south;

        //Calculate coordinate-step per block
        xDelta = xDiffCor/imageWidth;
        zDelta = zDiffCor/imageHeight;

    }

    //Check if coordinates occur in map
    public boolean inRegion(Double x, Double z){
        boolean inRegion = false;

        if(x <= east && x >= west && z <= north && z >= south){
            inRegion = true;
        }

        return inRegion;
    }

    //Get minecraft X from Latitude
    public int getXfromCor(Double x){

        //Calculate difference
        Double xDiff = x-west;

        //Calculate result
        Double xResult = (xDiff/xDiffCor)*imageWidth;

        return  xResult.intValue();
    }

    //Get minecraft Z from longditude
    public int getZfromCor(Double z){

        //Calculate difference
        Double zDiff = north-z;

        //Calculate result
        Double zResult = (zDiff/zDiffCor)*imageHeight;

        return  zResult.intValue();
    }


    //--------------------------------------------------------------//
                //Waarschijnlijk niet meer nodig//
    //--------------------------------------------------------------//

    public void getLocationMC(Double x, Double z){

        //Print header
        System.out.println("\nMinecraft z, x\n-------------------");

        //Calculate difference
        Double xDiff = x-west;
        Double zDiff = north-z;

        //Calculate result
        Double xResult = (xDiff/xDiffCor)*imageWidth;
        Double zResult = (zDiff/zDiffCor)*imageHeight;

        //Print result
        System.out.println("z, lat: "+zResult.intValue());
        System.out.println("x, long: "+xResult.intValue());
    }

    public void getLocationKM(Double x, Double z){

        //Print header
        System.out.println("\nKilometers\n-------------------");

        //Calculate difference
        Double xDiff = x-west;
        Double zDiff = north-z;

        //Calculate result
        Double xResult = (xDiff/xDiffCor)*widthKM;
        Double zResult = (zDiff/zDiffCor)*heightKM;

        //Print result
        System.out.println("lat: "+zResult);
        System.out.println("long: "+xResult);
    }

    public void getCoordinates(int x, int z){

        //Print header
        System.out.println("\nCoordinates\n-------------------");

        //Calculate result
        Double xResult = (x*xDelta)+west;
        Double zResult = north-(z*zDelta);

        //Print result
        System.out.println("lat: "+zResult);
        System.out.println("long: "+xResult);

        // getLocationMC(xResult,zResult);
        // getLocationKM(xResult,zResult);
    }
}
