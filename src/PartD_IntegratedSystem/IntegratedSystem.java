import java.util.Scanner;

public class CampusServiceCentre {

    static StudentQueue queue = new StudentQueue(4);
    static StudentLinkedList records = new StudentLinkedList();
    static int[] serviceTimes = {12, 5, 8, 4, 15, 7};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== CAMPUS SERVICE CENTRE ===");
            System.out.println("1. Add student to waiting queue");
            System.out.println("2. Serve next student");
            System.out.println("3. Display waiting students");
            System.out.println("4. Add student service record");
            System.out.println("5. Display student service records");
            System.out.println("6. Search for student record");
            System.out.println("7. Remove student record");
            System.out.println("8. Display daily statistics");
            System.out.println("9. Sort service times");
            System.out.println("10. Run sorting experiment");
            System.out.println("11. Exit");
            System.out.print("Select option: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addToQueue(sc);          break;
                case 2: System.out.println("Served: " + queue.dequeue()); break;
                case 3: queue.displayQueue();    break;
                case 4: addRecord(sc);           break;
                case 5: records.displayStudents(); break;
                case 6: searchRecord(sc);        break;
                case 7: deleteRecord(sc);        break;
                case 8: new DailyStatistics(serviceTimes).printStatistics(); break;
                case 9: sortServiceTimes();      break;
                case 10: SortingExperiment.main(new String[0]); break;
                case 11: System.out.println("Goodbye."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 11);

        sc.close();
    }

    private static void addToQueue(Scanner sc) {
        System.out.print("Student no: ");   String no   = sc.nextLine();
        System.out.print("Name: ");         String name = sc.nextLine();
        System.out.print("Service type: "); String type = sc.nextLine();
        System.out.print("Service time (min): "); int time = sc.nextInt(); sc.nextLine();
        queue.enqueue(new Student(no, name, type, time));
    }

    private static void addRecord(Scanner sc) {
        System.out.print("Student no: ");   String no   = sc.nextLine();
        System.out.print("Name: ");         String name = sc.nextLine();
        System.out.print("Service type: "); String type = sc.nextLine();
        System.out.print("Service time (min): "); int time = sc.nextInt(); sc.nextLine();
        records.insertStudent(new Student(no, name, type, time));
        System.out.println("Record added.");
    }

    private static void searchRecord(Scanner sc) {
        System.out.print("Enter student no to search: ");
        Student found = records.searchStudent(sc.nextLine());
        System.out.println(found != null ? "Found: " + found : "Not found.");
    }

    private static void deleteRecord(Scanner sc) {
        System.out.print("Enter student no to delete: ");
        boolean removed = records.deleteStudent(sc.nextLine());
        System.out.println(removed ? "Deleted." : "Not found.");
    }

    private static void sortServiceTimes() {
        SortResult r = MergeSort.sort(serviceTimes);
        System.out.print("Sorted service times: ");
        for (int v : r.sortedArray) System.out.print(v + " ");
        System.out.println("(" + r.comparisons + " comparisons)");
    }
}
