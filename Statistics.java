import java.util.*;
import java.io.*;

public class Statistics {
    private ProvinceData data;
    private List<TeritoryUnit> citiesWithLongestNames;

    public Statistics(String fileName) {
        this.data = new ProvinceData(fileName);
        findCities();
    } 

    public void findCities() {
        List<TeritoryUnit> cities = new ArrayList<TeritoryUnit>();

        for (TeritoryUnit unit: this.data.getTeritoryUnits()) {
            if ((unit instanceof City) || (unit instanceof CountyAndCity)) {
                cities.add(unit);
            }
        }
        Collections.sort(cities);
        this.citiesWithLongestNames = cities;
    }

    public String takeCitiesWithLongestNames() {
        String names = "";
        for (int i = 0; i < 3; i++) {
            names += citiesWithLongestNames.get(i).getCommunityName() + "\n";
        }
        return names;
    }

    public String findCounty() {    // finds county with the largest number of communities
        int number = 0;
        String countyName = "";
        for (TeritoryUnit unit: this.data.getTeritoryUnits()) {
            if (unit instanceof County) {
                int amountOfCommunities = countAppearances(unit.getCountyNo());
                if (amountOfCommunities > number) {
                    number = amountOfCommunities;
                    countyName = unit.getCommunityName();
                }
            }
        }
        return countyName;
    }

    private int countAppearances(int number) {
        int amount = 0;
        for (TeritoryUnit unit: this.data.getTeritoryUnits()) {
            if (unit.getCountyNo() == number) {
                amount++;
            } if (unit.getCountyNo() > number) {
                break;
            }
        }
        return amount;
    }

    public static void main(String args[]) {
        Statistics test = new Statistics("malopolska.csv");
        
        System.out.println(test.takeCitiesWithLongestNames());
        System.out.println(test.findCounty());
    }
}