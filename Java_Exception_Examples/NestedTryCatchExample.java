public class NestedTryCatchExample {
    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        int index = 2;
        int divisor = 0;

        try {
            try {
                int value = array[index];
                System.out.println("Accessed value: " + value);
                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}