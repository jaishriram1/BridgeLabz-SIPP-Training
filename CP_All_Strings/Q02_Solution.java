public class Q2_NullPointerDemo {
    public static void generateNullPointer() {
        String text = null;
        System.out.println("Text length: " + text.length());
    }

    public static void handleNullPointer() {
        String text = null;
        try {
            System.out.println("Text length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught General Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // generateNullPointer(); // Uncomment to crash
        handleNullPointer();
    }
}