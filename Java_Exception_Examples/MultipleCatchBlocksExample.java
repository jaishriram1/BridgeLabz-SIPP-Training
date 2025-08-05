public class MultipleCatchBlocksExample {
    public static void main(String[] args) {
        int[] array = null;
        int index = 3;
        try {
            int value = array[index];
            System.out.println("Value at index " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}