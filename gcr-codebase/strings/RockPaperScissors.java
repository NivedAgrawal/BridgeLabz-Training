import java.util.*;

public class RockPaperScissors {

    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[(int)(Math.random() * 3)];
    }

    public static String getResult(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("scissors") && comp.equals("paper")) ||
            (user.equals("paper") && comp.equals("rock"))) {
            return "User";
        }
        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userWins = 0, compWins = 0, games;
        System.out.print("Enter number of games: ");
        games = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < games; i++) {
            System.out.print("Enter rock/paper/scissors: ");
            String user = sc.nextLine().toLowerCase();
            String comp = getComputerChoice();
            String result = getResult(user, comp);
            System.out.println("Computer: " + comp + " | Result: " + result);

            if (result.equals("User")) userWins++;
            else if (result.equals("Computer")) compWins++;
        }

        System.out.println("\nTotal Games: " + games);
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + compWins);
        System.out.printf("User Win %%: %.2f%%\n", userWins * 100.0 / games);
        System.out.printf("Computer Win %%: %.2f%%\n", compWins * 100.0 / games);
    }
}
