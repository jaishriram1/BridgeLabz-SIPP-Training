import java.util.Scanner;

public class Q6_FindReplace {
    public static String findAndReplace(String sentence, String find, String replace) {
        return sentence.replace(find, replace);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence:");
        String sentence = sc.nextLine();
        System.out.print("Enter word to find: ");
        String find = sc.next();
        System.out.print("Enter replacement: ");
        String replace = sc.next();

        String result = findAndReplace(sentence, find, replace);
        System.out.println("Modified Sentence: " + result);
    }
}
