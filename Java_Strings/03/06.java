import java.util.Scanner;

public class Q6_WordLengthTable {
    public static String[] splitWords(String text) {
        return text.trim().split("\\s+");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = splitWords(input);
        System.out.println("Word\tLength");
        for (String word : words) {
            System.out.println(word + "\t" + word.length());
        }
    }
}