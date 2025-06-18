// Java solution for Question 19.
import java.util.*;
public class Q19_RockPaperScissors {

    public static String getComputerChoice() {
        String[] options = {"rock", "paper", "scissors"};
        return options[new Random().nextInt(3)];
    }

    public static String getResult(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if (user.equals("rock") && comp.equals("scissors") ||
            user.equals("scissors") && comp.equals("paper") ||
            user.equals("paper") && comp.equals("rock"))
            return "User";
        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds, userWin = 0, compWin = 0;
        System.out.print("Enter number of rounds: ");
        rounds = sc.nextInt();

        for (int i = 0; i < rounds; i++) {
            System.out.print("Enter your move (rock/paper/scissors): ");
            String user = sc.next().toLowerCase();
            String comp = getComputerChoice();
            String winner = getResult(user, comp);
            System.out.println("Computer chose: " + comp);
            System.out.println("Result: " + winner);

            if (winner.equals("User")) userWin++;
            else if (winner.equals("Computer")) compWin++;
        }

        System.out.println("\nGame Over");
        System.out.println("User Wins: " + userWin);
        System.out.println("Computer Wins: " + compWin);
        System.out.printf("User Win %%: %.2f%%\n", 100.0 * userWin / rounds);
        System.out.printf("Computer Win %%: %.2f%%\n", 100.0 * compWin / rounds);
    }
}