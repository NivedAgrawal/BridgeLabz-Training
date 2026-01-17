package LinearAndBinarySearch;
import java.util.Arrays;

public class LinearBinaryChallenge {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1, 2};
        int target = 4;

        // Linear Search for first missing positive
        int missing = firstMissingPositive(nums.clone()); // use clone to preserve original array
        System.out.println("First missing positive: " + missing);

        // Binary Search for target index
        Arrays.sort(nums); // Required for binary search
        int index = binarySearch(nums, target);
        System.out.println("Index of " + target + ": " + index);
    }

    // ✅ First Missing Positive Integer (Linear Search approach)
    static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++)
            if (arr[i] != i + 1)
                return i + 1;

        return n + 1;
    }

    // ✅ Binary Search
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
