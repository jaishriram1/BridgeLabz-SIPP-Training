import java.util.Scanner;

public class Q2_CompareStringLengthAndResult {
    public static int manualLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count++);
            }
        } catch (Exception e) {}
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int len1 = manualLength(s1);
        int len2 = manualLength(s2);
        boolean same = len1 == len2;

        System.out.println("String 1 length: " + len1);
        System.out.println("String 2 length: " + len2);
        System.out.println("Are lengths equal? " + same);
    }
}
