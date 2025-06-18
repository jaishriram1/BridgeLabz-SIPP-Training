// Java solution for Question 20.
import java.util.Scanner;

public class Q20_TrimString {
    public static String manualTrim(String text) {
        int start = 0, end = text.length() - 1;
        while (start < text.length() && text.charAt(start) == ' ') start++;
        while (end >= 0 && text.charAt(end) == ' ') end--;
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text with spaces:");
        String input = sc.nextLine();

        String manual = manualTrim(input);
        String builtin = input.trim();

        System.out.println("Manual Trim: [" + manual + "]");
        System.out.println("Built-in Trim: [" + builtin + "]");
        System.out.println("Are both equal? " + compare(manual, builtin));
    }
}
