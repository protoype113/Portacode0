import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Login {

    public static String username;

    public static void login() {
        boolean valid = false;
        while (valid == false) {
            System.out.print("Enter your username: ");
            username = Format.scan.next();
            File file = new File("./users/" + username + ".sv");
            if (file.exists() && file.isFile()) {
                System.out.println("Please confirm username: " + username + " (y/n)");
                String confirm = Format.scan.next();
                if (confirm.equals("y")) {
                    System.out.println("Username confirmed");
                    valid = true;
                }
            } else {
                System.out.println("Username " + username + " not found. Would you like to create a new account? (y/n)");
                String confirm = Format.scan.next();
                if (confirm.equals("y")) {
                    System.out.println("Username confirmed");
                    try {
                        file.createNewFile();
                    } catch (IOException e) {

                    }
                    valid = true;
                }
            }
        }
    }

}