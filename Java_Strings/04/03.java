import java.util.HashMap;
import java.util.Scanner;

public class Q3_CharFrequency {
    public static HashMap<Character, Integer> getFrequency(String text) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        HashMap<Character, Integer> freq = getFrequency(input);
        System.out.println("Character\tFrequency");
        for (char ch : freq.keySet()) {
            System.out.println(ch + "\t\t" + freq.get(ch));
        }
    }
}
