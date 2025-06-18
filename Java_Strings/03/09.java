import java.util.Scanner;

public class Q9_VowelConsonantIn2DArray {
    public static String getType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch += 32;
        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) >= 0) return "Vowel";
            return "Consonant";
        }
        return "Symbol";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[][] result = new String[input.length()][2];
        for (int i = 0; i < input.length(); i++) {
            result[i][0] = String.valueOf(input.charAt(i));
            result[i][1] = getType(input.charAt(i));
        }

        System.out.println("Char\tType");
        for (String[] row : result) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }
}
