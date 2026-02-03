import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.hashMap;
import java.util.Scanner;
public class hw1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String fileName = scan.next();
        File file = new File(fileName);
        Scanner fileReader = new Scanner(file);
        Map<char, double> map = new hashMap<>();
        while (fileReader.hasNextLine()) {
            String next = fileReader.next();
            try {
                Double.parseDouble(next);
            } catch(exception e) {
                if (next.contains("=")) {
                    if (next.contains("*")) {

                    } else if (next.contains("/")) {

                    } else if (next.contains("+")) {

                    } else if (next.contains("-")) {}

                } else {

                }
            }

        }
    }
}