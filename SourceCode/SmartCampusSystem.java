import java.util.List;
import java.util.Scanner;

/** Entry point and interactive menu for the Smart Campus system. */
public class SmartCampusSystem {
    private final Scanner input = new Scanner(System.in);
    private final StudentService students = new StudentService();
    private final ResourceService resources = new ResourceService();
    private final BookingService bookings = new BookingService(resources);
    private final AnalyticsService analytics = new AnalyticsService(students, resources, bookings);

    public static void main(String[] args) { new SmartCampusSystem().start(); }

    private void start() {
        seedData();
        System.out.println("\n=== SMART CAMPUS RESOURCE MANAGEMENT SYSTEM ===");
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            try {
                switch (input.nextLine().trim()) {
                    case "1": addStudent(); break;
                    case "2": showStudents(); break;
                    case "3": findStudent(); break;
                    case "4": addResource(); break;
                    case "5": showResources(); break;
                    case "6": makeBooking(); break;
                    case "7": showBookings(); break;
                    case "8": analytics.printReport(); break;
                    case "9": concurrentBookingDemo(); break;
                    case "0": running = false; break;
                    default: System.out.println("Please enter a number from 0 to 9.");
                }
            } catch (IllegalArgumentException exception) { System.out.println("Error: " + exception.getMessage()); }
        }
        System.out.println("Thank you for using Smart Campus.");
    }

    private void printMenu() {
        System.out.println("\n1. Add student       2. View students       3. Search student");
        System.out.println("4. Add resource      5. View resources      6. Book resource");
        System.out.println("7. View bookings     8. Analytics           9. Concurrency demo");
        System.out.println("0. Exit");
    }
    private void addStudent() { students.add(new Student(read("Student ID"), read("Name"), read("Department"))); System.out.println("Student added successfully."); }
    private void showStudents() {
        List<Student> list = students.getAllSortedByName();
        if (list.isEmpty()) { System.out.println("No students found."); return; }
        System.out.println("\nID       Name                         Department\n-----------------------------------------------------");
        list.forEach(System.out::println);
    }
    private void findStudent() {
        Student student = students.findById(read("Student ID"));
        System.out.println(student == null ? "Student not found." : "Found: " + student.details());
    }
    private void addResource() { resources.add(new CampusResource(read("Resource ID"), read("Resource name"), read("Type"))); System.out.println("Resource added successfully."); }
    private void showResources() {
        if (resources.getAll().isEmpty()) { System.out.println("No resources found."); return; }
        System.out.println("\nID       Resource                     Type             Status\n------------------------------------------------------------------");
        resources.getAll().forEach(System.out::println);
    }
    private void makeBooking() {
        String studentId = read("Student ID");
        if (students.findById(studentId) == null) throw new IllegalArgumentException("Student ID does not exist.");
        Booking booking = bookings.create(studentId, read("Resource ID"), read("Purpose"));
        System.out.println("Booking " + booking.getBookingId() + " confirmed.");
    }
    private void showBookings() {
        if (bookings.getAll().isEmpty()) { System.out.println("No bookings found."); return; }
        System.out.println("\nBooking  Student  Resource  Purpose\n------------------------------------------------------");
        bookings.getAll().forEach(System.out::println);
    }
    private void concurrentBookingDemo() {
        resources.makeAvailable("DEMO-1", "Innovation Lab", "Laboratory");
        System.out.println("Two students are requesting the Innovation Lab simultaneously...");
        Thread first = new Thread(new BookingAttempt(bookings, "S001", "DEMO-1", "Project work"), "Student-S001");
        Thread second = new Thread(new BookingAttempt(bookings, "S002", "DEMO-1", "Club meeting"), "Student-S002");
        first.start(); second.start();
        try { first.join(); second.join(); } catch (InterruptedException exception) { Thread.currentThread().interrupt(); }
        System.out.println("Only one booking succeeds because the booking service is synchronized.");
    }
    private String read(String label) { System.out.print(label + ": "); return InputValidator.required(input.nextLine(), label); }
    private void seedData() {
        students.add(new Student("S001", "Aarav Sharma", "Computer Science"));
        students.add(new Student("S002", "Diya Patel", "Electronics"));
        resources.add(new CampusResource("R101", "Seminar Hall", "Room"));
        resources.add(new CampusResource("R102", "3D Printer", "Equipment"));
    }
}
