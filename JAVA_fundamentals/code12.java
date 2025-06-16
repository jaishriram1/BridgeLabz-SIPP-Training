import java.util.Scanner;

public class code12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = scanner.nextDouble();

        double yards = distanceInFeet / 3;
        double miles = yards / 1760;

        System.out.printf("The distance in yards is %.2f while the distance in miles is %.4f\n", yards, miles);
    }
}