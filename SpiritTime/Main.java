import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        clearConsole();
        System.out.println();
        System.out.println("Welcome to ERN, the Entity Routing Network.");
        System.out.println("As our newest agent, you will be tasked with locating and containing entities of various danger levels.");
        while (true) {
            System.out.println("Options");
            System.out.println("1. Locate Entities");
            System.out.println("2. ");
            String a = scan.next();
            if (a.equals("c")) {
                break;
            }

        }
    }

    public static void clearConsole() {
        try {
            // ANSI escape code:
            // \033[H moves the cursor to the top-left corner
            // \033[2J clears the entire screen
            System.out.print("\033[H\033[2J");
            System.out.flush(); // Force the output to be written immediately
        } catch (Exception e) {
            // Handle exceptions (e.g., if the terminal doesn't support ANSI codes)
            e.printStackTrace();
        }
    }
}