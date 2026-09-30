public class InsertionSort {

    public static SortResult sort(int[] input) {
        int[] a = input.clone();
        long comparisons = 0;
        long shifts = 0;

        long start = System.nanoTime();

        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                comparisons++;
                a[j + 1] = a[j];
                shifts++;
                j--;
            }
            if (j >= 0) comparisons++; // the comparison that stopped the loop
            a[j + 1] = key;
        }

        long end = System.nanoTime();
        return new SortResult(a, comparisons, shifts, end - start);
    }

    public static void trace(int[] input) {
        int[] a = input.clone();
        for (int i = 1; i < Math.min(4, a.length); i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
            System.out.println("Pass " + i + ": " + java.util.Arrays.toString(a));
        }
    }
}
