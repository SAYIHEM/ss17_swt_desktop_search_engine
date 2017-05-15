import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesktopSearch {

    private Map<String, ResourceType> types;
    private Index index;

    public DesktopSearch() {

        this.index = new Index();
        this.types = new TreeMap<>();
    }

    public void registerType(String extension, ResourceType type) throws NullPointerException, IllegalArgumentException {

        if (extension == null) {
            throw new NullPointerException("Extension cant be NULL!");
        }
        if (type == null) {
            throw new NullPointerException("Type cant be NULL!");
        }

        if (extension.isEmpty()) {
            throw new IllegalArgumentException("Extension cant be empty!");
        }

        if (this.types.containsKey(extension)) {

            this.types.replace(extension, type);

        } else {

            this.types.put(extension, type);
        }
    }

    public ResourceType getType(String extension) throws NullPointerException, IllegalArgumentException {

        if (extension == null) {

            return null;
        }

        if (extension.isEmpty()) {
            throw new IllegalArgumentException("Extension cant be empty!");
        }

        if (this.types.containsKey(extension)) {

            return this.types.get(extension);

        } else {

            return null;
        }
    }

    public void unregisterType(String extension) throws NullPointerException, IllegalArgumentException {

        if (extension == null) {
            throw new NullPointerException("Extension cant be NULL!");
        }

        if (extension.isEmpty()) {
            throw new IllegalArgumentException("Extension cant be empty!");
        }

        this.types.remove(extension);
    }

    public void registerResource(Resource res) throws NullPointerException {

        if (res == null) {
            throw new NullPointerException("Resource cant be NULL!");
        }

        this.index.add(res);
    }

    public List<Resource> processRequest(String request) throws NullPointerException, IllegalArgumentException {

        if (request == null) {
            throw new NullPointerException("Request cant be NULL!");
        }

        if (request.isEmpty()) {
            throw new IllegalArgumentException("Request cant be empty!");
        }

        return this.index.getResources(request);
    }
}
