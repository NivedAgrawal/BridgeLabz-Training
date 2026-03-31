package scenerio_based;

import java.util.*;

//Custom Exception
class InvalidQuizSubmissionException extends Exception {
 public InvalidQuizSubmissionException(String message) {
     super(message);
 }
}

//Quiz Processor Class
class QuizProcessor {
 private String[] correctAnswers;
 private List<Integer> scores;

 public QuizProcessor(String[] correctAnswers) {
     this.correctAnswers = correctAnswers;
     this.scores = new ArrayList<>();
 }

 // Compare answers and calculate score
 public int calculateScore(String[] userAnswers) throws InvalidQuizSubmissionException {
     if (userAnswers.length != correctAnswers.length) {
         throw new InvalidQuizSubmissionException("Answer length mismatch!");
     }

     int score = 0;
     for (int i = 0; i < correctAnswers.length; i++) {
         if (userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
             score++;
         }
     }
     scores.add(score); // store score for this user
     return score;
 }

 // Return grade based on score
 public String getGrade(int score) {
     double percentage = (score * 100.0) / correctAnswers.length;

     if (percentage >= 90) return "A";
     else if (percentage >= 75) return "B";
     else if (percentage >= 50) return "C";
     else return "D";
 }

 // Get all scores
 public List<Integer> getAllScores() {
     return scores;
 }
}

//Driver Class
public class QuizPlatform {
 public static void main(String[] args) {
     String[] correctAnswers = {"A", "B", "C", "D", "A"};

     QuizProcessor processor = new QuizProcessor(correctAnswers);

     // Example user submissions
     String[] user1 = {"A", "B", "C", "D", "A"}; // all correct
     String[] user2 = {"A", "C", "C", "D", "B"}; // partially correct
     String[] user3 = {"A", "B", "C"};           // invalid length

     try {
         int score1 = processor.calculateScore(user1);
         System.out.println("User1 Score: " + score1 + ", Grade: " + processor.getGrade(score1));

         int score2 = processor.calculateScore(user2);
         System.out.println("User2 Score: " + score2 + ", Grade: " + processor.getGrade(score2));

         int score3 = processor.calculateScore(user3); // will throw exception
         System.out.println("User3 Score: " + score3 + ", Grade: " + processor.getGrade(score3));
     } catch (InvalidQuizSubmissionException e) {
         System.out.println("Error: " + e.getMessage());
     }

     // Print all scores
     System.out.println("All Scores: " + processor.getAllScores());
 }
}


