package SortingAlgorithms;
public class MergeSortBookPrices {
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            merge(prices, left, mid, right);
        }
    }

    public static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = prices[mid + 1 + j];

        // Merge the temp arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k++] = L[i++];
            } else {
                prices[k++] = R[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) {
            prices[k++] = L[i++];
        }

        while (j < n2) {
            prices[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        int[] bookPrices = {399, 249, 129, 499, 199};
        System.out.println("Original Book Prices:");
        for (int price : bookPrices) {
            System.out.print(price + " ");
        }

        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("\nSorted Book Prices:");
        for (int price : bookPrices) {
            System.out.print(price + " ");
        }
    }
}
