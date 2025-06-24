public class WordReplacer {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        String result = replaceWord("I love Java", "Java", "Python");
        System.out.println("Modified: " + result);
    }
}