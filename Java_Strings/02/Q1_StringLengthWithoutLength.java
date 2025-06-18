import java.util.Scanner;

public class Q1_StringLengthWithoutLength {
    public static int manualLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println("Manual Length: " + manualLength(input));
        System.out.println("Built-in Length: " + input.length());
    }
}
