/** A bookable campus facility or item. */
public class CampusResource {
    private final String id, name, type;
    private boolean available = true;
    public CampusResource(String id, String name, String type) { this.id = InputValidator.required(id, "Resource ID"); this.name = InputValidator.required(name, "Resource name"); this.type = InputValidator.required(type, "Resource type"); }
    public String getId() { return id; }
    public boolean isAvailable() { return available; }
    public void reserve() { available = false; }
    public void release() { available = true; }
    public String toString() { return String.format("%-8s %-28s %-16s %s", id, name, type, available ? "Available" : "Booked"); }
}
