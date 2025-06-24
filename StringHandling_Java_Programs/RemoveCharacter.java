public class RemoveCharacter {
    public static String removeChar(String str, char ch) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != ch) result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Modified String: " + removeChar("Hello World", 'l'));
    }
}