// Java solution for Question 18.
import java.util.Scanner;

public class Q18_WordLengthTable {

    public static String[] splitWords(String text) {
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

    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void display(String[][] data) {
        System.out.println("Word\tLength");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] words = splitWords(input);
        String[][] result = getWordLengthArray(words);
        display(result);
    }
}
