import java.util.Scanner;
import java.util.LinkedHashSet;

public class Q2_UniqueCharacters {
    public static String getUniqueCharacters(String text) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char ch : text.toCharArray()) {
            set.add(ch);
        }
        StringBuilder result = new StringBuilder();
        for (char ch : set) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        String unique = getUniqueCharacters(input);
        System.out.println("Unique characters: " + unique);
    }
}
