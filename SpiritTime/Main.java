import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main (String[] args) {
        // Entity a = new Entity("Pikachu", "001");
        // Entity b = new Entity("Gyarados", "002");
        // Entity[] team = {a, b};
        // User man = new User("Gary", team);
        // System.out.println(man.getName());
        // man.listContained();

        clearConsole();
        System.out.println();
        System.out.println("Welcome to ERN, the Entity Routing Network.");
        System.out.println("As our newest agent, you will be tasked with locating and containing ");
        System.out.println("entities of various danger levels.");
        hold();
        clearConsole();
        System.out.println();
        while (true) {
            System.out.println("Options");
            System.out.println("1. Locate New Entities");
            System.out.println("2. Interact With Contained Entities");
            System.out.println("3. Agency Entity Manual");
            String a = scan.next();
            if (a.equals("1")) {
                encounter();
            } else if (a.equals("2")) {
                caught();
            } else if (a.equals("3")) {
                manual();
            } else if (a.equals("c")) {
                break;
            } else {
                clearConsole();
                System.out.println();
                System.out.print("Invalid, please select another ");
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

    public static void hold() {
        System.out.println("Press \"ENTER\" to continue...");
        scan.nextLine();
    }

    public static void encounter() {
        System.out.println("A");
    }

    public static void caught() {
        System.out.println("B");
    }

    public static void manual() {
        System.out.println("C");
    }
}
