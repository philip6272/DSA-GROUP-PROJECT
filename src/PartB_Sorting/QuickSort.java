public class QuickSort {

    public static SortResult sort(int[] input) {
        int[] a = input.clone();
        long[] counters = new long[1];

        long start = System.nanoTime();
        quickSort(a, 0, a.length - 1, counters);
        long end = System.nanoTime();

        return new SortResult(a, counters[0], 0, end - start);
    }

    private static void quickSort(int[] a, int low, int high, long[] counters) {
        if (low < high) {
            int p = partition(a, low, high, counters);
            quickSort(a, low, p - 1, counters);
            quickSort(a, p + 1, high, counters);
        }
    }

    private static int partition(int[] a, int low, int high, long[] counters) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            counters[0]++;
            if (a[j] <= pivot) {
                i++;
                int temp = a[i]; a[i] = a[j]; a[j] = temp;
            }
        }
        int temp = a[i + 1]; a[i + 1] = a[high]; a[high] = temp;
        return i + 1;
    }
}
