import java.util.Scanner;

public class Q1_BMIReport {

    // Calculate BMI and return status
    public static String[] computeBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 24.9) status = "Normal";
        else if (bmi < 29.9) status = "Overweight";
        else status = "Obese";

        return new String[]{String.format("%.1f", weight), String.format("%.1f", heightCm),
                String.format("%.2f", bmi), status};
    }

    // Compute BMI for all persons
    public static String[][] calculateReport(double[][] data) {
        String[][] report = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            report[i] = computeBMI(data[i][0], data[i][1]);
        }
        return report;
    }

    // Display report
    public static void displayReport(String[][] report) {
        System.out.printf("%-10s%-10s%-10s%-15s%n", "Weight", "Height", "BMI", "Status");
        for (String[] row : report) {
            System.out.printf("%-10s%-10s%-10s%-15s%n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2]; // weight, height
        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Person %d: ", i + 1);
            data[i][0] = sc.nextDouble(); // weight
            data[i][1] = sc.nextDouble(); // height
        }

        String[][] report = calculateReport(data);
        displayReport(report);
    }
}
