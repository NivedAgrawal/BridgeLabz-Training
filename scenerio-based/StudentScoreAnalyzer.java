package scenerio_based;

class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

public class StudentScoreAnalyzer {

    public static double calculateAverage(int[] scores) throws InvalidScoreException {
        int sum = 0;
        for (int score : scores) {
            validateScore(score);
            sum += score;
        }
        return (double) sum / scores.length;
    }

    public static int findMax(int[] scores) throws InvalidScoreException {
        int max = scores[0];
        for (int score : scores) {
            validateScore(score);
            if (score > max) max = score;
        }
        return max;
    }

    public static int findMin(int[] scores) throws InvalidScoreException {
        int min = scores[0];
        for (int score : scores) {
            validateScore(score);
            if (score < min) min = score;
        }
        return min;
    }

    private static void validateScore(int score) throws InvalidScoreException {
        if (score < 0 || score > 100) {
            throw new InvalidScoreException("Invalid score detected: " + score);
        }
    }

    public static void main(String[] args) {
        int[] scores = {85, 90, 78, 92};

        try {
            System.out.println("Average: " + calculateAverage(scores));
            System.out.println("Highest: " + findMax(scores));
            System.out.println("Lowest: " + findMin(scores));
        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
    }
}

