package SortingAlgorithms;
public class SelectionSortExamScores {
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {72, 88, 64, 95, 70};
        System.out.println("Original Exam Scores:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }

        selectionSort(examScores);

        System.out.println("\nSorted Exam Scores:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }
}
