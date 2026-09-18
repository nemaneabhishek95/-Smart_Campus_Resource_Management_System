/** Immutable record of a successful resource reservation. */
public class Booking {
    private final String bookingId, studentId, resourceId, purpose;
    public Booking(String bookingId, String studentId, String resourceId, String purpose) { this.bookingId = bookingId; this.studentId = studentId; this.resourceId = resourceId; this.purpose = purpose; }
    public String getBookingId() { return bookingId; }
    public String toString() { return String.format("%-8s %-8s %-9s %s", bookingId, studentId, resourceId, purpose); }
}
