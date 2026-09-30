public class MergeSort {

    public static SortResult sort(int[] input) {
        int[] a = input.clone();
        long[] counters = new long[1]; // counters[0] = comparisons
        long start = System.nanoTime();

        mergeSort(a, 0, a.length - 1, counters);

        long end = System.nanoTime();
        return new SortResult(a, counters[0], 0, end - start);
    }

    private static void mergeSort(int[] a, int low, int high, long[] counters) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid, counters);
            mergeSort(a, mid + 1, high, counters);
            merge(a, low, mid, high, counters);
        }
    }

    private static void merge(int[] a, int low, int mid, int high, long[] counters) {
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];

        for (int i = 0; i < left.length; i++) left[i] = a[low + i];
        for (int i = 0; i < right.length; i++) right[i] = a[mid + 1 + i];

        int i = 0, j = 0, k = low;
        while (i < left.length && j < right.length) {
            counters[0]++;
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }
        while (i < left.length) a[k++] = left[i++];
        while (j < right.length) a[k++] = right[j++];
    }
}
