import java.util.Scanner;

public class Q10_WordLengthTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence:");
        String[] words = sc.nextLine().trim().split("\\s+");

        System.out.println("Word\tLength");
        for (String word : words) {
            System.out.println(word + "\t" + word.length());
        }
    }
}