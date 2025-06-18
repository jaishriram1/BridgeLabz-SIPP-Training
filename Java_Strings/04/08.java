import java.util.Scanner;

public class Q8_LongestWord {
    public static String findLongest(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) longest = word;
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        System.out.println("Longest word: " + findLongest(input));
    }
}
