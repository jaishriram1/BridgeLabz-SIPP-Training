import java.util.Scanner;

public class Question_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        double totalBonus = 0.0, totalOld = 0.0, totalNew = 0.0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            salaries[i] = input.nextDouble();
            System.out.print("Enter years of service: ");
            years[i] = input.nextDouble();

            if (salaries[i] <= 0 || years[i] < 0) {
                System.out.println("Invalid input, please re-enter.");
                i--;
                continue;
            }

            double bonus = (years[i] > 5) ? 0.05 * salaries[i] : 0.02 * salaries[i];
            bonuses[i] = bonus;
            newSalaries[i] = salaries[i] + bonus;
            totalBonus += bonus;
            totalOld += salaries[i];
            totalNew += newSalaries[i];
        }

        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOld);
        System.out.println("Total New Salary: " + totalNew);
        input.close();
    }
}
