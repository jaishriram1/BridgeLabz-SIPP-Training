import java.util.Scanner;

public class Question_16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        char[] grades = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter mark for subject " + (j + 1) + ": ");
                marks[i][j] = input.nextInt();
                if (marks[i][j] < 0) {
                    System.out.println("Negative mark entered. Try again.");
                    j--;
                }
            }

            int sum = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = sum / 3.0;

            if (percentages[i] >= 90) grades[i] = 'A';
            else if (percentages[i] >= 80) grades[i] = 'B';
            else if (percentages[i] >= 70) grades[i] = 'C';
            else if (percentages[i] >= 60) grades[i] = 'D';
            else grades[i] = 'F';
        }

        System.out.println("Results:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + " => Percentage: " + percentages[i] + "%, Grade: " + grades[i]);
        }

        input.close();
    }
}
