// Java solution for Question 16.
import java.util.Scanner;

public class Q16_ShortestLongestWord {

    public static String[] splitText(String text) {
        return text.trim().split("\\s+");
    }

    public static int getLength(String word) {
        int count = 0;
        try {
            while (true) {
                word.charAt(count++);
            }
        } catch (Exception e) {}
        return count;
    }

    public static int[] getWordLengths(String[] words) {
        int[] lengths = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lengths[i] = getLength(words[i]);
        }
        return lengths;
    }

    public static int[] findShortestLongest(String[] words, int[] lengths) {
        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < lengths.length; i++) {
            if (lengths[i] < lengths[minIndex]) minIndex = i;
            if (lengths[i] > lengths[maxIndex]) maxIndex = i;
        }
        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] words = splitText(input);
        int[] lengths = getWordLengths(words);
        int[] result = findShortestLongest(words, lengths);

        System.out.println("Shortest word: " + words[result[0]]);
        System.out.println("Longest word: " + words[result[1]]);
    }
}
