package SortingAlgorithms;
public class HeapSortSalaries {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // call max heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    public static void heapify(int[] salaries, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // If left child is larger
        if (leftChild < heapSize && salaries[leftChild] > salaries[largest])
            largest = leftChild;

        // If right child is larger
        if (rightChild < heapSize && salaries[rightChild] > salaries[largest])
            largest = rightChild;

        // If largest is not root
        if (largest != rootIndex) {
            int temp = salaries[rootIndex];
            salaries[rootIndex] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(salaries, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        int[] expectedSalaries = {50000, 45000, 60000, 42000, 55000};
        System.out.println("Original Salaries:");
        for (int salary : expectedSalaries) {
            System.out.print(salary + " ");
        }

        heapSort(expectedSalaries);

        System.out.println("\nSorted Salaries:");
        for (int salary : expectedSalaries) {
            System.out.print(salary + " ");
        }
    }
}

