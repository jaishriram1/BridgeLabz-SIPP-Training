import java.util.Scanner;

public class code23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter salary (INR): ");
        double salary = scanner.nextDouble();
        System.out.print("Enter bonus (INR): ");
        double bonus = scanner.nextDouble();

        double totalIncome = salary + bonus;

        System.out.printf("The salary is INR %.2f and the bonus is INR %.2f. Hence Total Income is INR %.2f\n", salary, bonus, totalIncome);
    }
}
