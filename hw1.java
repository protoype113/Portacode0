import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class hw1 {

    // function for PRINT
    public static void printing(Scanner fileReader, String next, Map<String, Integer> map) {
        String printed = "";
            next = fileReader.next();
            while (!next.equals(";")) {
                if (map.containsKey(next)) {
                    printed = printed + map.get(next);
                } else {
                    printed = printed + next;
                }
                next = fileReader.next();
            }
            System.out.println(printed);    
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String fileName = scan.next();
        File file = new File(fileName);
        Scanner fileReader = new Scanner(file);
        Map<String, Integer> map = new HashMap<>();
        String previous = "";
        String next = "";
        while (fileReader.hasNextLine()) {
            previous = next;
            next = fileReader.next();
            // For loop

            // Set value
            if (next.matches("=")) {
                next = fileReader.next();
                try {
                    int check = Integer.parseInt(next);
                    map.put(previous, check);
                } catch (Exception e) {
                    map.put(previous, map.get(next));
                }
            }
            // Change value 
            // print value
            else if (next.equals("PRINT")) {
                printing(fileReader, next, map);
            }
            // semi-colon
             

            

            // try {
            //     Double.parseDouble(next);
            // } catch(exception e) {
            //     if (next.contains("=")) {
            //         if (next.contains("*")) {

            //         } else if (next.contains("/")) {

            //         } else if (next.contains("+")) {

            //         } else if (next.contains("-")) {}

            //     } else {

            //     }
            // }

        }
        scan.close();
    }
}