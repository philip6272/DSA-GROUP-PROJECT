public class ArrayStats {

    public static void main(String[] args) {

        // service times from the task sheet
        int[] times = {12, 5, 8, 4, 15, 7};

        int totalStudents = times.length;
        int totalTime = 0;
        int highest = times[0];
        int lowest = times[0];
        int over10 = 0;

        System.out.println("===== A4: ARRAY SERVICE-TIME STATISTICS =====");
        System.out.println();

        System.out.println("Service times:");
        for (int i = 0; i < times.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + times[i] + " minutes");
        }
        System.out.println();

        // go through the array once and work everything out
        for (int i = 0; i < times.length; i++) {
            totalTime = totalTime + times[i];

            if (times[i] > highest) {
                highest = times[i];
            }

            if (times[i] < lowest) {
                lowest = times[i];
            }

            if (times[i] > 10) {
                over10++;
            }
        }

        double average = (double) totalTime / totalStudents;

        System.out.println("Total students served: " + totalStudents);
        System.out.println("Total service time: " + totalTime + " minutes");
        System.out.println("Average service time: " + average + " minutes");
        System.out.println("Highest service time: " + highest + " minutes");
        System.out.println("Lowest service time: " + lowest + " minutes");
        System.out.println("Students with service time greater than 10 minutes: " + over10);
    }
}
