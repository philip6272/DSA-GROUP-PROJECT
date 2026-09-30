public class SelectionSort {

    public static SortResult sort(int[] input) {
        int[] a = input.clone();
        long comparisons = 0;
        long swaps = 0;

        long start = System.nanoTime();

        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
                swaps++;
            }
        }

        long end = System.nanoTime();
        return new SortResult(a, comparisons, swaps, end - start);
    }

    /** Prints the array after the first three passes — for the report. */
    public static void trace(int[] input) {
        int[] a = input.clone();
        int n = a.length;
        for (int i = 0; i < Math.min(3, n - 1); i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) minIndex = j;
            }
            int temp = a[i]; a[i] = a[minIndex]; a[minIndex] = temp;
            System.out.println("Pass " + (i + 1) + ": " + java.util.Arrays.toString(a));
        }
    }
}
