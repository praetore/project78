package MinecraftHaven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Peter on 19-5-2015.
 */
public class DataReader {
    ArrayList<Object> objects = new ArrayList<Object>();
    File file = new File("Resources/data.csv");

    BufferedReader reader = null;

    //String nameRegex = "(\\d{1});(\\d+);\\d+;\\d+;(\\d+);(\\d+);";
    String nameRegex = "(.+);.+;.+;.+;(.+);(.+)";

    Pattern pattern = Pattern.compile(nameRegex);


    public void readData(){
        try{
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            CoordinateCalculator cal = new CoordinateCalculator();

            System.out.println("Type, x, z");
            while((text = reader.readLine())!=null){

                Matcher m = pattern.matcher(text);
                if (m.find( )) {
                    String type = m.group(1).toString();
                    Double x = Double.parseDouble(m.group(2).toString());
                    Double z = Double.parseDouble(m.group(3).toString());

                    if(cal.inRegion(x,z)) {
                        System.out.println(type + ", " + cal.getXfromCor(x) + ", " + cal.getZfromCor(z));
                    }
                    //Pioneer pioneer = new Pioneer(name, birthYear, deathYear, subject);
                    //pioneers.add(pioneer);

                } else {
                    System.out.println("regex-error");
                    //Whitelines
                    continue;
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //psvm
    public static void main(String[] args) {
        DataReader dr = new DataReader();
        dr.readData();
    }

}
