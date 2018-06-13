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

    public ProvinceData(String fileName) {
        this.teritoryUnits = new ArrayList<TeritoryUnit>();
        
        try {
            readDataFromFile(fileName);

        } catch (FileNotFoundException e1) {
            System.out.println("No matching file.");
        } catch (NumberFormatException e2) {
            System.out.println("Failed while parsing. ProvinceData has not been created.");
        }
        
    }

    public List<TeritoryUnit> getTeritoryUnits() {
        return this.teritoryUnits;
    }

    private void readDataFromFile(String fileName) throws FileNotFoundException {
        this.scanner = new Scanner(new File(fileName));

        while (this.scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("woj\tpow\tgmi\trgmi\tnazwa\ttyp")) {
                continue;
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
            addCounty(arr);

        } else {
            addCommunity(arr);

        }
    }

    private void addCounty(String arr[]) {
        if (arr[COMMUNITY_TYPE].equals("powiat")) {
            this.teritoryUnits.add(new County(convertToInt(arr[PROVINCE_NO]), convertToInt(arr[COUNTY_NO]), arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));
        } else {
            this.teritoryUnits.add(new CountyAndCity(convertToInt(arr[PROVINCE_NO]), convertToInt(arr[COUNTY_NO]), arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));
        }
    }

    private void addCommunity(String arr[]) {
        if (arr[COMMUNITY_TYPE].equals("gmina miejska")) {
            this.teritoryUnits.add(new CityCommunity(convertToInt(arr[PROVINCE_NO]), convertToInt(arr[COUNTY_NO]), convertToInt(arr[COMMUNITY_NO]), convertToInt(arr[COMMUNITY_TYPE_NO]), 
                                    arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));

        } else if(arr[COMMUNITY_TYPE].equals("gmina wiejska")) {
            this.teritoryUnits.add(new CountryCommunity(convertToInt(arr[PROVINCE_NO]), convertToInt(arr[COUNTY_NO]), convertToInt(arr[COMMUNITY_NO]), convertToInt(arr[COMMUNITY_TYPE_NO]), 
                                    arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));
        } else if(arr[COMMUNITY_TYPE].equals("gmina miejsko-wiejska")) {
            this.teritoryUnits.add(new CityAndCountryCommunity(convertToInt(arr[PROVINCE_NO]), convertToInt(arr[COUNTY_NO]), convertToInt(arr[COMMUNITY_NO]), convertToInt(arr[COMMUNITY_TYPE_NO]), 
                                    arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));
        } else if(arr[COMMUNITY_TYPE].equals("obszar wiejski")) {
            this.teritoryUnits.add(new CountryArea(convertToInt(arr[PROVINCE_NO]), convertToInt(arr[COUNTY_NO]), convertToInt(arr[COMMUNITY_NO]), convertToInt(arr[COMMUNITY_TYPE_NO]), 
                                    arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));
        } else if(arr[COMMUNITY_TYPE].equals("miasto")) {
            this.teritoryUnits.add(new City(convertToInt(arr[PROVINCE_NO]), convertToInt(arr[COUNTY_NO]), convertToInt(arr[COMMUNITY_NO]), convertToInt(arr[COMMUNITY_TYPE_NO]), 
                                    arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));   
        } else {
            this.teritoryUnits.add(new Delegature(convertToInt(arr[PROVINCE_NO]), convertToInt(arr[COUNTY_NO]), convertToInt(arr[COMMUNITY_NO]), convertToInt(arr[COMMUNITY_TYPE_NO]), 
                                    arr[COMMUNITY_NAME], arr[COMMUNITY_TYPE]));         
        }
    }

    private int convertToInt(String number) throws NumberFormatException {
        return Integer.parseInt(number);
    }

    public static void main(String args[]) {
        ProvinceData test = new ProvinceData("malopolska.csv");
        for (TeritoryUnit unit: test.teritoryUnits) {
            System.out.println(unit.toString());
        }
    }
}