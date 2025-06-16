import java.util.Scanner;

public class code25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();

        double celsiusResult = (fahrenheit - 32) * 5 / 9;

        System.out.printf("The %.2f fahrenheit is %.2f celsius\n", fahrenheit, celsiusResult);
    }
}