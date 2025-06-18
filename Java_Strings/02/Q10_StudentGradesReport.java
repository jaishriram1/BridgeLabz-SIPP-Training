import java.util.Random;

public class Q10_StudentGradesReport {
    public static int[][] generateScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            scores[i][0] = 40 + rand.nextInt(61);
            scores[i][1] = 40 + rand.nextInt(61);
            scores[i][2] = 40 + rand.nextInt(61);
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] result = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = result[i][1];
        }
        return result;
    }

    public static String[] getGrades(double[] percents) {
        String[] grade = new String[percents.length];
        for (int i = 0; i < percents.length; i++) {
            if (percents[i] >= 90) grade[i] = "A";
            else if (percents[i] >= 75) grade[i] = "B";
            else if (percents[i] >= 60) grade[i] = "C";
            else if (percents[i] >= 45) grade[i] = "D";
            else grade[i] = "F";
        }
        return grade;
    }

    public static void main(String[] args) {
        int[][] scores = generateScores(5);
        double[][] stats = calculateStats(scores);
        double[] percents = new double[stats.length];
        for (int i = 0; i < stats.length; i++) percents[i] = stats[i][2];
        String[] grades = getGrades(percents);

        System.out.println("Phy Chem Math | Total  Avg   %   Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%3d %4d %4d | %5.0f %5.1f %5.1f  %s
",
                scores[i][0], scores[i][1], scores[i][2],
                stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }
}
