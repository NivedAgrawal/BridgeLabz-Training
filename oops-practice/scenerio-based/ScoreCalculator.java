package scenerio_based;

import java.util.ArrayList;
import java.util.List;

// Custom Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

public class ScoreCalculator {

    // Method to calculate score
    public static int calculateScore(String[] correctAnswers, String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException(
                    "Number of user answers does not match number of questions");
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    // Method to calculate grade
    public static String calculateGrade(int score, int totalQuestions) {
        double percentage = (score * 100.0) / totalQuestions;

        if (percentage >= 80)
            return "A";
        else if (percentage >= 60)
            return "B";
        else if (percentage >= 40)
            return "C";
        else
            return "Fail";
    }

    public static void main(String[] args) {

        String[] correctAnswers = {"A", "C", "B", "D", "A"};

        String[] user1Answers = {"A", "C", "B", "D", "A"};
        String[] user2Answers = {"A", "B", "B", "D", "C"};

        List<Integer> userScores = new ArrayList<>();

        try {
            int score1 = calculateScore(correctAnswers, user1Answers);
            userScores.add(score1);
            System.out.println("User 1 Score: " + score1);
            System.out.println("User 1 Grade: " +
                    calculateGrade(score1, correctAnswers.length));

            int score2 = calculateScore(correctAnswers, user2Answers);
            userScores.add(score2);
            System.out.println("User 2 Score: " + score2);
            System.out.println("User 2 Grade: " +
                    calculateGrade(score2, correctAnswers.length));

        } catch (InvalidQuizSubmissionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("All User Scores: " + userScores);
    }
}

