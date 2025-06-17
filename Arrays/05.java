import java.util.Scanner;

public class Question_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int[] multiplicationResult = new int[4];

        for (int i = 6, j = 0; i <= 9; i++, j++) {
            multiplicationResult[j] = number * i;
        }

        for (int i = 6, j = 0; i <= 9; i++, j++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[j]);
        }

        input.close();
    }
}
