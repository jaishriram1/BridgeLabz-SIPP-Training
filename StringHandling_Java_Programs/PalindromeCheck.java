public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--)
            rev += str.charAt(i);
        return str.equalsIgnoreCase(rev);
    }

    public static void main(String[] args) {
        System.out.println("Is Palindrome: " + isPalindrome("madam"));
    }
}