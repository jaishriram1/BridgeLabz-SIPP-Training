// Java solution for Question 12.
import java.util.Scanner;
import java.util.Arrays;

public class Q12_SplitComparison {

    public static String[] manualSplit(String text) {
        String[] words = new String[100];
        int count = 0;
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                if (word.length() > 0) {
                    words[count++] = word.toString();
                    word.setLength(0);
                }
            } else {
                word.append(ch);
            }
        }
        if (word.length() > 0) {
            words[count++] = word.toString();
        }

        return Arrays.copyOf(words, count);
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        String[] manual = manualSplit(text);
        String[] builtin = text.split(" ");

        System.out.println("Manual Split: " + Arrays.toString(manual));
        System.out.println("Built-in Split: " + Arrays.toString(builtin));
        System.out.println("Are both equal? " + compareArrays(manual, builtin));
    }
}
