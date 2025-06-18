import java.util.Scanner;

public class Q5_SentencePalindrome {
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = text.length() - 1;
        while (i < j) {
            if (text.charAt(i++) != text.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        boolean result = isPalindrome(sentence);
        System.out.println("Is Palindrome? " + result);
    }
}
