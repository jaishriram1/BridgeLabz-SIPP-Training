import java.util.Scanner;

public class code28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter side 1 of the park in meters: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter side 2 of the park in meters: ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter side 3 of the park in meters: ");
        double side3 = scanner.nextDouble();

        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000; // 5 km in meters
        double rounds = totalDistance / perimeter;

        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km\n", rounds);
    }
}
