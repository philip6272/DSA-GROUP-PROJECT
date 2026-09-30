import java.util.Random;

public class SortingExperiment {

    public static void main(String[] args) {
        int[] sizes = {20, 50, 100, 500};

        System.out.printf("%-15s %-10s %-15s %-15s%n",
                "Algorithm", "Size", "Comparisons", "Time (ns)");
        System.out.println("-----------------------------------------------------");

        Random r = new Random(42);

        for (int size : sizes) {
            int[] original = new int[size];
            for (int i = 0; i < size; i++) original[i] = r.nextInt(1000);

            int[] sel = original.clone();
            int[] ins = original.clone();
            int[] mer = original.clone();
            int[] qui = original.clone();

            SortResult rSel = SelectionSort.sort(sel);
            SortResult rIns = InsertionSort.sort(ins);
            SortResult rMer = MergeSort.sort(mer);
            SortResult rQui = QuickSort.sort(qui);

            print("Selection Sort", size, rSel);
            print("Insertion Sort", size, rIns);
            print("Merge Sort",     size, rMer);
            print("Quick Sort",     size, rQui);

            System.out.println();
        }
    }

    private static void print(String name, int size, SortResult r) {
        System.out.printf("%-15s %-10d %-15d %-15d%n",
                name, size, r.comparisons, r.timeNs);
    }
}
