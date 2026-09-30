public class SortResult {
    public int[] sortedArray;
    public long comparisons;
    public long swaps;
    public long timeNs;

    public SortResult(int[] sortedArray, long comparisons, long swaps, long timeNs) {
        this.sortedArray = sortedArray;
        this.comparisons = comparisons;
        this.swaps = swaps;
        this.timeNs = timeNs;
    }
}
