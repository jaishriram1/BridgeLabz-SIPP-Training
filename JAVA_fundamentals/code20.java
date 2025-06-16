import java.util.Scanner;

public class code20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheitResult = (celsius * 9 / 5) + 32;

        System.out.printf("The %.2f celsius is %.2f fahrenheit\n", celsius, fahrenheitResult);
    }
}