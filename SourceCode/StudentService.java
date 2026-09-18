import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Handles student storage, lookup, and sorting. */
public class StudentService {
    private final Map<String, Student> students = new HashMap<>();
    public void add(Student student) {
        if (students.containsKey(student.getId())) throw new IllegalArgumentException("A student with that ID already exists.");
        students.put(student.getId(), student);
    }
    public Student findById(String id) { return students.get(id); }
    public List<Student> getAllSortedByName() {
        List<Student> result = new ArrayList<>(students.values());
        result.sort(Comparator.comparing(student -> student.getName().toLowerCase()));
        return result;
    }
    public int count() { return students.size(); }
}
