public class ArrayStats {

    private int[] serviceTimes;

    public ArrayStats(int[] serviceTimes) {
        this.serviceTimes = serviceTimes;
    }

    /**
     * Traverses the array once and prints all required statistics.
     */
    public void printStatistics() {
        System.out.println("===== A4: ARRAY SERVICE-TIME STATISTICS =====");
        System.out.println();

        // Print the raw array values
        System.out.println("Service times:");
        for (int i = 0; i < serviceTimes.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + serviceTimes[i] + " minutes");
        }
        System.out.println();

        // Edge case: no data
        if (serviceTimes.length == 0) {
            System.out.println("No students served today.");
            return;
        }

        int totalStudents = serviceTimes.length;
        int totalTime     = 0;
        int highest       = serviceTimes[0];
        int lowest        = serviceTimes[0];
        int countAbove10  = 0;

        // Single traversal to compute everything
        for (int i = 0; i < serviceTimes.length; i++) {
            int time = serviceTimes[i];
            totalTime += time;

            if (time > highest) highest = time;
            if (time < lowest)  lowest  = time;
            if (time > 10)      countAbove10++;
        }

        double average = (double) totalTime / totalStudents;

        // Print results
        System.out.println("Total students served: " + totalStudents);
        System.out.println("Total service time: " + totalTime + " minutes");
        System.out.println("Average service time: " + average + " minutes");
        System.out.println("Highest service time: " + highest + " minutes");
        System.out.println("Lowest service time: " + lowest + " minutes");
        System.out.println("Students with service time greater than 10 minutes: " + countAbove10);
    }

    /** Simple demo runner. */
    public static void main(String[] args) {
        int[] serviceTimes = {12, 5, 8, 4, 15, 7};
        new ArrayStats(serviceTimes).printStatistics();
    }
}
