package SortingAlgorithms;
public class BubbleSortStudentMarks {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // If no elements were swapped, array is sorted
        }
    }

    public static void main(String[] args) {
        int[] studentMarks = {88, 67, 92, 75, 83};
        System.out.println("Original Marks:");
        for (int mark : studentMarks) {
            System.out.print(mark + " ");
        }

        bubbleSort(studentMarks);

        System.out.println("\nSorted Marks:");
        for (int mark : studentMarks) {
            System.out.print(mark + " ");
        }
    }
}
