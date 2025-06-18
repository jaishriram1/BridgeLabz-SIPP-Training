import java.util.Scanner;

public class Q9_ReplaceChar {
    public static String replaceChar(String text, char oldChar, char newChar) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            sb.append(ch == oldChar ? newChar : ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String input = sc.nextLine();
        System.out.print("Enter character to replace: ");
        char oldChar = sc.next().charAt(0);
        System.out.print("Enter new character: ");
        char newChar = sc.next().charAt(0);

        System.out.println("Modified Text: " + replaceChar(input, oldChar, newChar));
    }
}
