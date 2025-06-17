import java.util.Scanner;

public class Question_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            weight[i] = input.nextDouble();
            System.out.print("Enter height (m) of person " + (i + 1) + ": ");
            height[i] = input.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) status[i] = "Underweight";
            else if (bmi[i] < 25) status[i] = "Normal";
            else if (bmi[i] < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        System.out.println("BMI Report:");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ": Height = " + height[i] + "m, Weight = " + weight[i] + "kg, BMI = " + bmi[i] + ", Status = " + status[i]);
        }

        input.close();
    }
}
