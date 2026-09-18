import java.util.ArrayList;
import java.util.List;

/** Coordinates bookings and protects shared resource availability. */
public class BookingService {
    private final ResourceService resources;
    private final List<Booking> bookings = new ArrayList<>();
    private int nextBookingNumber = 1;
    public BookingService(ResourceService resources) { this.resources = resources; }
    public synchronized Booking create(String studentId, String resourceId, String purpose) {
        CampusResource resource = resources.findById(resourceId);
        if (resource == null) throw new IllegalArgumentException("Resource ID does not exist.");
        if (!resource.isAvailable()) throw new IllegalArgumentException("That resource is already booked.");
        resource.reserve();
        Booking booking = new Booking(String.format("B%03d", nextBookingNumber++), studentId, resourceId, InputValidator.required(purpose, "Purpose"));
        bookings.add(booking);
        return booking;
    }
    public List<Booking> getAll() { return new ArrayList<>(bookings); }
    public int count() { return bookings.size(); }
}
