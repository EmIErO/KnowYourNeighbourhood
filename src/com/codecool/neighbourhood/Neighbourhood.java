package com.codecool.neighbourhood;

import com.codecool.neighbourhood.statistics.*;
import com.codecool.neighbourhood.tables.*;
import com.codecool.neighbourhood.teitory_unit.*;

import java.util.*;

public class Neighbourhood {

    private Statistics stat;
    private Scanner reader;
    private String currentInput; 

    private boolean isRunning = true;

    public Neighbourhood(String fileName) {
        this.stat = new Statistics(fileName);
        this.reader = new Scanner(System.in);
    }

    public static void main(String args[]) {
        Neighbourhood neighbourhood = new Neighbourhood("malopolska.csv");
        neighbourhood.run();
    }

    private void run() {
        while (isRunning) {
            printMenu();
            getInput("Option: ");
            handleMenu();
        }
        
    }

    private void printMenu() {
        List<String> options = Arrays.asList("Exit program", 
                                                "List statistics",
                                                "Display 3 cities with longest names",
                                                "Display county's name with the largest number of communities",
                                                "Display locations, that belong to more than one category",
                                                "Advanced search");

        System.out.println("\nWhat would you like to do:\n");
        for (int i = 1; i < options.size(); i++) {
            System.out.println("\t" + "(" + i + ") " + options.get(i));
        }
        System.out.println("\t" + "(0) " + options.get(0) + "\n\n");
    }

    private void getInput(String message) {
        System.out.print(message);
        this.currentInput = this.reader.nextLine();
    }

    private void handleMenu() {
        switch (this.currentInput) {
                case "0":
                    this.isRunning = false;
                    break;
                case "1":
                    TableType1 stat = new TableType1(this.stat.getProvinceData().getTeritoryUnits());
                    System.out.println(stat.getTable());
                    break;
                case "2":
                    this.stat.findCities();
                    System.out.println(this.stat.takeCitiesWithLongestNames());
                    break;
                case "3":
                    System.out.println(this.stat.findCounty());
                    break;
                case "4":
                    for (String name: this.stat.findLocationsWithMultipleCategories()) {
                        System.out.println(name);
                    }
                    break;
                case "5":
                    getInput("Advanced search: ");
                    this.stat.findMatchingUnits(this.currentInput);

                    TableType2 resultTable = new TableType2(this.stat.getSearchedUnits(), Arrays.asList("LOCATION", "TYPE"));
                    System.out.println(resultTable.getTable());
                    break;
        }
    }
}