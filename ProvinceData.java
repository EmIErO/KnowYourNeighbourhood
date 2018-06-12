import java.util.*;
import java.io.*;

public class ProvinceData {
    private List<TeritoryUnit> teritoryUnits;
    private Scanner scanner;

    private final int PROVINCE_NO = 0;
    private final int COUNTY_NO = 1;
    private final int COMMUNITY_NO = 2;
    private final int COMMUNITY_TYPE_NO = 3;
    private final int COMMUNITY_NAME = 4;
    private final int COMMUNITY_TYPE = 5;

    public ProvinceData(String fileName) throws FileNotFoundException, NumberFormatException{
        this.teritoryUnits = new ArrayList<TeritoryUnit>();
        readDataFromFile(fileName);
    }

    private void readDataFromFile(String fileName) throws FileNotFoundException {
        this.scanner = new Scanner(new File(fileName));

        while (this.scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("woj\tpow\tgmi\trgmi\tnazwa\ttyp")) {
                continue;
                //System.out.println("Line: " + line);  
            } else {
                String arr[] = line.split("\t");
                addTeritoryUnit(arr);
            }
        }
    }
    

    private void addTeritoryUnit(String arr[]) throws NumberFormatException {
        if (arr[COUNTY_NO].equals("") && arr[COMMUNITY_NO].equals("") && arr[COMMUNITY_TYPE_NO].equals("")) {
            
            this.teritoryUnits.add(new Province(convertToInt(arr[PROVINCE_NO]), arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));

        } else if (arr[COMMUNITY_NO].equals("") && arr[COMMUNITY_TYPE_NO].equals("")) {
            
            this.teritoryUnits.add(new County(convertToInt(arr[PROVINCE_NO]), convertToInt(arr[COUNTY_NO]), arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));

        } else {
            
            this.teritoryUnits.add(new Community(convertToInt(arr[PROVINCE_NO]), convertToInt(arr[COUNTY_NO]), convertToInt(arr[COMMUNITY_NO]), convertToInt(arr[COMMUNITY_TYPE_NO]), 
                                                arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));

        }
    }

    private int convertToInt(String number) throws NumberFormatException {
        return Integer.parseInt(number);
    }

    public static void main(String args[]) {
        try {
            ProvinceData test = new ProvinceData("malopolska.csv");
            for (TeritoryUnit unit: test.teritoryUnits) {
                System.out.println(unit.toString());
            }
        } catch (FileNotFoundException e1) {
            System.out.println("No matching file.");
        } catch (NumberFormatException e2) {
            System.out.println("Failed while parsing.");
        }
        
        
    }
}