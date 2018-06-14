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
            getInput();
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

        System.out.println("What would you like to do:\n");
        for (int i = 1; i < options.size(); i++) {
            System.out.println("\t" + "(" + i + ") " + options.get(i));
        }
        System.out.println("\t" + "(0) " + options.get(0));
    }

    private void getInput() {
        System.out.print("Option: ");
        this.currentInput = this.reader.nextLine();
    }

    
}