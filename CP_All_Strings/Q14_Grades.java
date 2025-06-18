// Java solution for Question 14.
import java.util.Random;
public class Q14_Grades {

    public static int[][] generateScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            scores[i][0] = 40 + rand.nextInt(61); // 40-100
            scores[i][1] = 40 + rand.nextInt(61);
            scores[i][2] = 40 + rand.nextInt(61);
        }
        return scores;
    }

    public static double[][] calculatePercentage(int[][] scores) {
        double[][] result = new double[scores.length][3]; // total, avg, percent
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = total / 3.0;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    public static String[] getGrade(double[] percent) {
        String[] grade = new String[percent.length];
        for (int i = 0; i < percent.length; i++) {
            double p = percent[i];
            if (p >= 90) grade[i] = "A";
            else if (p >= 75) grade[i] = "B";
            else if (p >= 60) grade[i] = "C";
            else if (p >= 45) grade[i] = "D";
            else grade[i] = "F";
        }
        return grade;
    }

    public static void main(String[] args) {
        int[][] scores = generateScores(5);
        double[][] result = calculatePercentage(scores);

        double[] percent = new double[result.length];
        for (int i = 0; i < result.length; i++) {
            percent[i] = result[i][2];
        }
        String[] grades = getGrade(percent);

        System.out.println("Phy Chem Math | Total Avg % | Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%3d %4d %4d | %5.0f %4.1f %5.1f | %s\n",
                scores[i][0], scores[i][1], scores[i][2],
                result[i][0], result[i][1], result[i][2], grades[i]);
        }
    }
}
