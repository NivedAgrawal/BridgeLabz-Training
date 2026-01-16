package SortingAlgorithms;

public class InsertionSortEmployeeIDs {
    public static void insertionSort(int[] ids) {
        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {104, 101, 109, 102, 105};
        System.out.println("Original Employee IDs:");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }

        insertionSort(employeeIDs);

        System.out.println("\nSorted Employee IDs:");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
    }
}
