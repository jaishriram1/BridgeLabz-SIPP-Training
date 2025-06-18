import java.util.Scanner;

public class Q4_CheckCharTypes {
    public static String getType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch += 32;
        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) >= 0) return "Vowel";
            return "Consonant";
        }
        return "Symbol";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Char\tType");
        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i) + "\t" + getType(input.charAt(i)));
        }
    }
}
