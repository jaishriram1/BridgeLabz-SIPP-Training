import java.util.Scanner;

public class Question_19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            personData[i][0] = input.nextDouble();
            System.out.print("Enter height (m) for person " + (i + 1) + ": ");
            personData[i][1] = input.nextDouble();

            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            double bmi = personData[i][2];
            if (bmi < 18.5) weightStatus[i] = "Underweight";
            else if (bmi < 25) weightStatus[i] = "Normal";
            else if (bmi < 30) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ": Height = " + personData[i][1] + ", Weight = " + personData[i][0] + ", BMI = " + personData[i][2] + ", Status = " + weightStatus[i]);
        }

        input.close();
    }
}
