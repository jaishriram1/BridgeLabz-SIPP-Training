import java.util.Scanner;

public class Question_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        double[] percentages = new double[n];
        char[] grades = new char[n];

        for (int i = 0; i < n; i++) {
            int physics, chemistry, maths;
            System.out.println("Student " + (i + 1) + ":");

            do {
                System.out.print("Enter Physics marks: ");
                physics = input.nextInt();
            } while (physics < 0);

            do {
                System.out.print("Enter Chemistry marks: ");
                chemistry = input.nextInt();
            } while (chemistry < 0);

            do {
                System.out.print("Enter Maths marks: ");
                maths = input.nextInt();
            } while (maths < 0);

            double percent = (physics + chemistry + maths) / 3.0;
            percentages[i] = percent;

            if (percent >= 90) grades[i] = 'A';
            else if (percent >= 80) grades[i] = 'B';
            else if (percent >= 70) grades[i] = 'C';
            else if (percent >= 60) grades[i] = 'D';
            else grades[i] = 'F';
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": " + percentages[i] + "%, Grade: " + grades[i]);
        }

        input.close();
    }
}
