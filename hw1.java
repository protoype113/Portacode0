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
    
    // overarching function to handle calculations
    public static Map<String, Integer> main2(Map<String, Integer> map, Scanner fileReader) {
        String previous = "";
        String next = "";
        while (fileReader.hasNext()) {
            previous = next;
            next = fileReader.next();
            // For loop
            if (next.equals("FOR")) {
                String loop = "";
                int repeat = Integer.parseInt(fileReader.next());
                next = fileReader.next();
                while (!next.equals("ENDFOR")) {
                    loop = loop + next + " ";
                    next = fileReader.next();
                    
                }
                System.out.println(loop);
                Scanner forLoop = new Scanner(loop);
                for (int i = 0; i < repeat; i++) {
                    map = main2(map, forLoop);
                }
            }
            
            // Set or change value 
            else if (next.contains("=")) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {

                }
                String op = next;
                next = fileReader.next();
                switch(op.charAt(0)) {
                    case '=':
                        try {
                            int check = Integer.parseInt(next);
                            map.put(previous, check);
                        } catch (Exception e) {
                            map.put(previous, map.get(next));
                        }
                    case '*':
                        try {
                            int check = Integer.parseInt(next);
                            map.put(previous, map.get(previous) * check);
                        } catch (Exception e) {
                            map.put(previous, map.get(previous) * map.get(next));
                        }
                        break;
                    case '+':
                        try {
                            int check = Integer.parseInt(next);
                            map.put(previous, map.get(previous) + check);
                        } catch (Exception e) {
                            map.put(previous, map.get(previous) + map.get(next));
                        }
                        break;
                    case '-':
                        try {
                            int check = Integer.parseInt(next);
                            map.put(previous, map.get(previous) - check);
                        } catch (Exception e) {
                            map.put(previous, map.get(previous) - map.get(next));
                        }
                        break;
                }
            }
            // print value
            else if (next.equals("PRINT")) {
                printing(fileReader, next, map);
            }
            // semi-colon
            else if (next.equals(";") && fileReader.hasNext() && !fileReader.hasNextLine()) {
                next = fileReader.next();
            }
             

        }
        return map;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String fileName = scan.next();
        File file = new File(fileName);
        Scanner fileReader = new Scanner(file);
        map = new HashMap<>(main2(map, fileReader));
        scan.close();
    }
}