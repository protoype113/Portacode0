import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

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
                int nested = 0;
                while (!next.equals("ENDFOR") || nested >= 1) {
                    if (next.equals("FOR")) {
                        nested += 1;
                    }
                    if (next.equals("ENDFOR")) {
                        nested -= 1;
                    }
                    loop = loop + next + " ";
                    next = fileReader.next();
                }
                loop = loop.replace(';', ' ');
                while(repeat > 0) {
                    System.out.println(repeat);
                    Scanner forLoop = new Scanner(loop);
                    map = new HashMap<>(main2(map, forLoop));
                    repeat --;
                }
            }
            
            // Set or change value 
            else if (next.contains("=")) {
                System.out.println("Before: " + previous + " : " + map.get(previous));
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
                System.out.println("After: " + previous + " : " + map.get(previous));
            }
            // print value
            else if (next.equals("PRINT")) {
                printing(fileReader, next, map);
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
        fileReader.close();
    }
}