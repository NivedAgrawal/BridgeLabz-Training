package LinearAndBinarySearch;
public class FirstNegativeSearch {
    public static void main(String[] args) {
        int[] arr = {5, 3, 0, -2, 4, -7};
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                index = i;
                break;
            }
        }

        System.out.println("Index of first negative number: " + index);
    }
}

