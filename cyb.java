public class cyb {
    public static void main(String[] args) {
        String plain = "HELLOWORLD";
        String cipher = "";
        for (int i = 0; i < plain.length(); i++) {
            System.out.print(plain.charAt(i) + " ");
            int x = (int) plain.charAt(i);
            System.out.print(x + " ");
            x = (5*x) + 8;
            System.out.print(x + " ");
            char ch = (char) x;
            System.out.println(ch);
            cipher = cipher + ch;
        }
        System.out.println(cipher);
        String plain2 = "";
        for (int i = 0; i < cipher.length(); i++) {
            System.out.print(cipher.charAt(i) + " ");
            int x = (int) cipher.charAt(i);
            System.out.print(x + " ");
            x = (x - 8) / 5;
            System.out.print(x + " ");
            char ch = (char) x;
            System.out.println(ch);
            plain2 = plain2 + ch;
        }
        System.out.println(plain2);
    }
}