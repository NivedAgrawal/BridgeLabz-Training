package LinearAndBinarySearch;
public class StringConcatPerformance {
    public static void main(String[] args) {
        int n = 1000000;

        long start1 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append("hello");
        }
        long end1 = System.nanoTime();
        System.out.println("StringBuffer time: " + (end1 - start1) + " ns");

        long start2 = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbd.append("hello");
        }
        long end2 = System.nanoTime();
        System.out.println("StringBuilder time: " + (end2 - start2) + " ns");
    }
}
