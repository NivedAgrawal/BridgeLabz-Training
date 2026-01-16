package SortingAlgorithms;
public class CountingSortStudentAges {
    public static void countingSort(int[] ages) {
        int min = 10; // minimum possible age
        int max = 18; // maximum possible age
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Count frequency of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in the correct position (stable sort)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - min] - 1] = age;
            count[age - min]--;
        }

        // Copy sorted array to original
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] studentAges = {13, 15, 10, 12, 18, 14, 11, 10, 16};
        System.out.println("Original Ages:");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }

        countingSort(studentAges);

        System.out.println("\nSorted Ages:");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
    }
}

