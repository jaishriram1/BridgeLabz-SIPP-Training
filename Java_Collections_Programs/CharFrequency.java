import java.util.*;

public class CharFrequency {
    public static void main(String[] args) {
        String input = "programming";
        Map<Character, Integer> charCount = new HashMap<>();

        for (char ch : input.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
