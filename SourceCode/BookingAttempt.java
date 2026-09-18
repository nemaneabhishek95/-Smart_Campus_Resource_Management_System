/** Runnable used solely to demonstrate safe concurrent reservation requests. */
public class BookingAttempt implements Runnable {
    private final BookingService bookings;
    private final String studentId, resourceId, purpose;
    public BookingAttempt(BookingService bookings, String studentId, String resourceId, String purpose) { this.bookings = bookings; this.studentId = studentId; this.resourceId = resourceId; this.purpose = purpose; }
    public void run() {
        try {
            Thread.sleep(100);
            bookings.create(studentId, resourceId, purpose);
            System.out.println(Thread.currentThread().getName() + ": booking succeeded.");
        } catch (IllegalArgumentException exception) {
            System.out.println(Thread.currentThread().getName() + ": " + exception.getMessage());
        } catch (InterruptedException exception) { Thread.currentThread().interrupt(); }
    }
}
