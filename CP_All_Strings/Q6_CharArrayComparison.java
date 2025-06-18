// Java solution for Question 6.
import java.util.Scanner;
import java.util.Arrays;

public class Q6_CharArrayComparison {

    public static char[] manualToCharArray(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        char[] manualChars = manualToCharArray(input);
        char[] builtinChars = input.toCharArray();

        boolean isEqual = compareCharArrays(manualChars, builtinChars);

        System.out.println("Manual chars: " + Arrays.toString(manualChars));
        System.out.println("Built-in chars: " + Arrays.toString(builtinChars));
        System.out.println("Are both equal? " + isEqual);
    }
}
