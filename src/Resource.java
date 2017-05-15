public class Resource {

    String name;
    String path;
    ResourceType rt;

    public Resource(String name, String path, ResourceType rt) throws NullPointerException, IllegalArgumentException {

        if (name == null) {
            throw new NullPointerException("Name cant be NULL!");
        }
        if (path == null) {
            throw new NullPointerException("Path cant be NULL!");
        }
        if (rt == null) {
            throw new NullPointerException("ResourceType cant be NULL!");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cant be empty!");
        }
        if (path.isEmpty()) {
            throw new IllegalArgumentException("Path cant be empty!");
        }

        this.name = name;
        this.path = path;
        this.rt = rt;
    }

    public String getName() {

        return name;
    }

    public String getPath() {

        return path;
    }

    public ResourceType getType() {

        return rt;
    }


}
