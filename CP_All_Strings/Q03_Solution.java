import java.util.Scanner;

public class Q3_LowercaseComparison {
    public static String toLowerCaseManual(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text:");
        String input = sc.nextLine();

        String manualLower = toLowerCaseManual(input);
        String builtinLower = input.toLowerCase();

        boolean isEqual = compareStrings(manualLower, builtinLower);

        System.out.println("Manual Lower: " + manualLower);
        System.out.println("Built-in Lower: " + builtinLower);
        System.out.println("Are both equal? " + isEqual);
    }
}