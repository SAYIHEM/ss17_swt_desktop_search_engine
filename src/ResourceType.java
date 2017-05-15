public class ResourceType {

    private String description;
    private KeywordCollector collector;

    public ResourceType(String desc, KeywordCollector collector) throws NullPointerException, IllegalArgumentException {

        if (desc == null) {
            throw new NullPointerException("Description cant be NULL!");
        }
        if (collector == null) {
            throw new NullPointerException("Collector cant be NULL!");
        }

        if (desc.isEmpty()) {
            throw new IllegalArgumentException("Description cant be empty!");
        }

        this.description = desc;
        this.collector = collector;
    }

    public String getDescription() {
        return description;
    }

    public KeywordCollector getCollector() {
        return collector;
    }
}
