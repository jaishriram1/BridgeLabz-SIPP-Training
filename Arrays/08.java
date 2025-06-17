import java.util.Scanner;

public class Question_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] array = new int[rows * cols];
        int index = 0;

        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
                array[index++] = matrix[i][j];
            }
        }

        System.out.println("1D Array:");
        for (int val : array) {
            System.out.print(val + " ");
        }

        input.close();
    }
}
