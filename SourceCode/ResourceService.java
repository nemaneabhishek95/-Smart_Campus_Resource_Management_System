import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Handles campus-resource storage and availability. */
public class ResourceService {
    private final Map<String, CampusResource> resources = new HashMap<>();
    public void add(CampusResource resource) {
        if (resources.containsKey(resource.getId())) throw new IllegalArgumentException("A resource with that ID already exists.");
        resources.put(resource.getId(), resource);
    }
    public CampusResource findById(String id) { return resources.get(id); }
    public List<CampusResource> getAll() { return new ArrayList<>(resources.values()); }
    public int count() { return resources.size(); }
    public long availableCount() { return resources.values().stream().filter(CampusResource::isAvailable).count(); }
    public void makeAvailable(String id, String name, String type) {
        CampusResource resource = resources.get(id);
        if (resource == null) add(new CampusResource(id, name, type)); else resource.release();
    }
}
