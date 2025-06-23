public class LexicographicalCompare {
    public static void compareStrings(String s1, String s2) {
        int result = s1.compareTo(s2);
        if (result == 0) System.out.println("Strings are equal");
        else if (result < 0) System.out.println(""" + s1 + "" comes before "" + s2 + """);
        else System.out.println(""" + s1 + "" comes after "" + s2 + """);
    }

    public static void main(String[] args) {
        compareStrings("apple", "banana");
    }
}