package LinearAndBinarySearch;
public class FirstLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 5, 6};
        int target = 4;
        int first = findIndex(arr, target, true);
        int last = findIndex(arr, target, false);
        System.out.println("First: " + first + ", Last: " + last);
    }

    static int findIndex(int[] arr, int target, boolean first) {
        int res = -1, left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                res = mid;
                if (first) right = mid - 1;
                else left = mid + 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return res;
    }
}
