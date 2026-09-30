public class SortResult {
    public final int[] sortedArray;
    public final long comparisons;
    public final long swaps;
    public final long timeNs;

    public SortResult(int[] sortedArray, long comparisons, long swaps, long timeNs) {
        this.sortedArray = sortedArray;
        this.comparisons = comparisons;
        this.swaps = swaps;
        this.timeNs = timeNs;
    }
}
