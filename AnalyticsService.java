/** Produces the dashboard summary used by the interactive menu. */
public class AnalyticsService {
    private final StudentService students;
    private final ResourceService resources;
    private final BookingService bookings;
    public AnalyticsService(StudentService students, ResourceService resources, BookingService bookings) { this.students = students; this.resources = resources; this.bookings = bookings; }
    public void printReport() {
        long available = resources.availableCount();
        System.out.println("\n--- Campus Analytics ---");
        System.out.println("Total students:  " + students.count());
        System.out.println("Total resources: " + resources.count());
        System.out.println("Total bookings:  " + bookings.count());
        System.out.println("Available:       " + available);
        System.out.println("Booked:          " + (resources.count() - available));
    }
}
