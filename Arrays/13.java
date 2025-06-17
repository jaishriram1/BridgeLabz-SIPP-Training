import java.util.Scanner;

public class Question_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int count = 0;
        int temp = number;
        while (temp > 0) {
            temp /= 10;
            count++;
        }

        int[] digits = new int[count];
        for (int i = 0; i < count; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        System.out.print("Digits in reverse order: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }

        input.close();
    }
}
