public class Main {
    public static void main(String[] args) {

        int[] serviceTimes = {12, 5, 8, 4, 15, 7};

        System.out.println("===== A4: DAILY STATISTICS (ARRAY) =====");
        System.out.println();

        int totalStudents = serviceTimes.length;
        int totalServiceTime = 0;
        int highest = serviceTimes[0];
        int lowest = serviceTimes[0];
        int countAbove10 = 0;

        for (int i = 0; i < serviceTimes.length; i++) {
            int t = serviceTimes[i];
            totalServiceTime += t;
            if (t > highest) highest = t;
            if (t < lowest) lowest = t;
            if (t > 10) countAbove10++;
        }

        double average = (double) totalServiceTime / totalStudents;

        System.out.println("Service times array: [12, 5, 8, 4, 15, 7]");
        System.out.println();
        System.out.println("Total students served       : " + totalStudents);
        System.out.println("Total service time (min)    : " + totalServiceTime);
        System.out.printf ("Average service time (min)  : %.1f%n", average);
        System.out.println("Highest service time (min)  : " + highest);
        System.out.println("Lowest service time (min)   : " + lowest);
        System.out.println("Services longer than 10 min : " + countAbove10);
    }
}
