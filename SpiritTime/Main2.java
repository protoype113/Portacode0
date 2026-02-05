import java.util.Scanner;

public class Main2 {
    public static Scanner scan = new Scanner(System.in);
    public static Entity[] dex = new Entity[30];
    

    public static void main (String[] args) {
        initializeDex();
        clearConsole();
        System.out.println();
        System.out.println("Welcome to ERN, the Entity Routing Network.");
        System.out.println("As our newest agent, you will be tasked with locating and containing ");
        System.out.println("entities of various danger levels.");
        hold();
        clearConsole();
        System.out.println();
        while (true) {
            System.out.println("options");
            System.out.println("1. Locate New Entities");
            System.out.println("2. Interact With Contained Entities");
            System.out.println("3. Agency Entity Manual");
            System.out.println("4. Exit Program");
            String a = scan.next();
            clearConsole();
            System.out.println();
            if (a.equals("1")) {
                encounter();
            } else if (a.equals("2")) {
                caught();
            } else if (a.equals("3")) {
                manual();
            } else if (a.equals("4")) {
                break;
            } else {
                System.out.print("Invalid, please select one of the valid ");
            }
            clearConsole();
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
        System.out.println("Accessing Dataase:  Search for entity by name or id");
        String search = scan.next();
        for (Entity e : dex) {
            if (search.equals(e.getID()) || search.equals(e.getName())) {
                System.out.println(e.getID() + " : " + e.getName());
            }
        }
        search = scan.nextLine();
        hold();
    }

    public static void initializeDex() {
        dex[0] = new Entity("Ashiarai yashiki", "001");
        dex[1] = new Entity("Baba Yaga", "002");
        dex[2] = new Entity("Chupacabra", "003");
        dex[3] = new Entity("Dullahan", "004");
        dex[4] = new Entity("Efreti", "005");
        dex[5] = new Entity("Fenrir", "006");
        dex[6] = new Entity("Gashadokuro", "007");
        dex[7] = new Entity("Huldra", "008");
        dex[8] = new Entity("Itsumade", "009");
        dex[9] = new Entity("Jiangshi", "010");
        dex[10] = new Entity("Kelpie", "011");
        dex[11] = new Entity("Leshy", "012");
        dex[12] = new Entity("Minotaur", "013");
        dex[13] = new Entity("Nue", "014");
        dex[14] = new Entity("Oni", "015");
        dex[15] = new Entity("Peryton", "016");
        dex[16] = new Entity("Qilin", "017");
        dex[17] = new Entity("Raiju", "018");
        dex[18] = new Entity("Skinwalker", "019");
        dex[19] = new Entity("Tengu", "020");
        dex[20] = new Entity("Undine", "021");
        dex[21] = new Entity("Valkyrie", "022");
        dex[22] = new Entity("Wendigo", "023");
        dex[23] = new Entity("Xuehe", "024");
        dex[24] = new Entity("Yuki-onna", "025");
        dex[25] = new Entity("Ziz", "026");
        dex[26] = new Entity("Anubis", "027");
        dex[27] = new Entity("Banshee", "028");
        dex[28] = new Entity("Chimera", "029");
        dex[29] = new Entity("Dybbuk", "030");
    }
}
