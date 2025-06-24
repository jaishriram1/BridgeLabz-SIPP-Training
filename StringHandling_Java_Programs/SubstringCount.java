public class SubstringCount {
    public static int countOccurrences(String str, String sub) {
        int count = 0;
        for (int i = 0; i <= str.length() - sub.length(); i++) {
            if (str.substring(i, i + sub.length()).equals(sub)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Occurrences: " + countOccurrences("abababa", "aba"));
    }
}