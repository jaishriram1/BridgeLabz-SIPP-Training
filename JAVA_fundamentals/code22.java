import java.util.Scanner;

public class code22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User inputs for name and cities
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter From City: ");
        String fromCity = scanner.nextLine();
        System.out.print("Enter Via City: ");
        String viaCity = scanner.nextLine();
        System.out.print("Enter To City: ");
        String toCity = scanner.nextLine();

        // User inputs for distances in miles
        System.out.print("Enter distance from From City to Via City (in miles): ");
        double fromToVia = scanner.nextDouble();
        System.out.print("Enter distance from Via City to To City (in miles): ");
        double viaToFinalCity = scanner.nextDouble();

        // User inputs for time in minutes
        System.out.print("Enter time taken from From City to Via City (in minutes): ");
        double timeFromToVia = scanner.nextDouble();
        System.out.print("Enter time taken from Via City to To City (in minutes): ");
        double timeViaToFinalCity = scanner.nextDouble();

        // Calculations
        double totalDistanceMiles = fromToVia + viaToFinalCity;
        double totalDistanceKm = totalDistanceMiles * 1.6;
        double totalTime = timeFromToVia + timeViaToFinalCity;

        System.out.printf(
            "The Total Distance travelled by %s from %s to %s via %s is %.2f km and the Total Time taken is %.2f minutes\n",
            name, fromCity, toCity, viaCity, totalDistanceKm, totalTime
        );
    }
}