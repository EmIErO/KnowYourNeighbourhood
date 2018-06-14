package com.codecool.neighbourhood.statistics;

import com.codecool.neighbourhood.tables.*;
import com.codecool.neighbourhood.teitory_unit.*;

import java.util.*;
import java.io.*;

public class Statistics {
    private ProvinceData data;
    private List<TeritoryUnit> citiesWithLongestNames;
    private List<TeritoryUnit> searchedUnits;

    public Statistics(String fileName) {
        this.data = new ProvinceData(fileName);
        this.searchedUnits = new ArrayList<TeritoryUnit>();
    } 

    public ProvinceData getProvinceData() {
        return this.data;
    }

    public List<TeritoryUnit> getSearchedUnits() {
        return this.searchedUnits;
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

    public List<String> findLocationsWithMultipleCategories() {
        List<String> locations = new ArrayList<String>();
        List<String> duplicates = new ArrayList<String>();
        for (TeritoryUnit unit: this.data.getTeritoryUnits()) {
            if (!locations.contains(unit.getCommunityName())) {
                locations.add(unit.getCommunityName());
            } else if (locations.contains(unit.getCommunityName()) && !duplicates.contains(unit.getCommunityName())) {
                duplicates.add(unit.getCommunityName());
            } else continue;
        }
        Collections.sort(duplicates);
        return duplicates;
    }

    public void findMatchingUnits(String pattern) {
        this.searchedUnits.clear();
        
        for (TeritoryUnit unit: this.data.getTeritoryUnits()) {
            if (matchWithUnit(unit, pattern)) {
                this.searchedUnits.add(unit);
            }
        }
        if (!this.searchedUnits.isEmpty()) {
            sortUnitsAlphabetically();
        }
    }

    private boolean matchWithUnit(TeritoryUnit unit, String pattern) {
        return unit.getCommunityName().toLowerCase().contains(pattern.toLowerCase());
    }

    private void sortUnitsAlphabetically() {
        Collections.sort(this.searchedUnits, new Comparator() {

        public int compare(Object o1, Object o2) {

            String comName1 = ((TeritoryUnit) o1).getCommunityName();
            String comName2 = ((TeritoryUnit) o2).getCommunityName();
            int sComp = comName1.compareTo(comName2);

            if (sComp != 0) {
               return sComp;
            } 

            String type1 = ((TeritoryUnit) o1).getCommunityType();
            String type2 = ((TeritoryUnit) o2).getCommunityType();
            return type1.compareTo(type2);
    }});
    }

    public static void main(String args[]) {
        Statistics test = new Statistics("malopolska.csv");
        
        System.out.println(test.takeCitiesWithLongestNames());
        System.out.println(test.findCounty());
        System.out.println(test.findLocationsWithMultipleCategories() + "\n");

        test.findMatchingUnits("tar");
        TableType2 testTable = new TableType2(test.searchedUnits, Arrays.asList("LOCATION", "TYPE"));
        System.out.println(testTable.getTable());
        
    }
}