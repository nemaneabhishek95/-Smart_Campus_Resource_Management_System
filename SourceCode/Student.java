/** Represents one registered campus student. */
public class Student {
    private final String id, name, department;
    public Student(String id, String name, String department) { this.id = InputValidator.required(id, "Student ID"); this.name = InputValidator.required(name, "Name"); this.department = InputValidator.required(department, "Department"); }
    public String getId() { return id; }
    public String getName() { return name; }
    public String details() { return id + " | " + name + " | " + department; }
    public String toString() { return String.format("%-8s %-28s %s", id, name, department); }
}
