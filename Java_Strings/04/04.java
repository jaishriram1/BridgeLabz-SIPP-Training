import java.util.HashMap;
import java.util.Scanner;

public class Q4_WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String[] words = sc.nextLine().trim().split("\\s+");

        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word\tFrequency");
        for (String word : freq.keySet()) {
            System.out.println(word + "\t" + freq.get(word));
        }
    }
}
