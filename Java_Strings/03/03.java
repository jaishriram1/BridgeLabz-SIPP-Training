import java.util.Scanner;

public class Q3_CompareCharArraysManually {
    public static char[] manualToCharArray(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char[] manual = manualToCharArray(input);
        char[] builtin = input.toCharArray();

        System.out.println("Equal: " + compareArrays(manual, builtin));
    }
}
