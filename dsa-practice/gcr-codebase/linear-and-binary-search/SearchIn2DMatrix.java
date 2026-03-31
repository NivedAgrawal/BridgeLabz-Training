package LinearAndBinarySearch;
public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 16;
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            int value = matrix[mid / cols][mid % cols];
            if (value == target) {
                found = true;
                break;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Found: " + found);
    }
}
   