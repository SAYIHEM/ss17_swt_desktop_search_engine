import java.util.*;

public class Index {

    private Map<String, List<Resource>> index = new TreeMap<>();

    public Index() {

    }

    public void add(Resource res) throws NullPointerException{

        if (res == null) {
            throw new NullPointerException("Resource to add cant be NULL!");
        }

        PlainTextCollector collector = new PlainTextCollector();
        Set<String> keywords = collector.getKeywords(res);

        for (String key : keywords) {

            // If Key already contained in the Index
            if (this.index.containsKey(key)) {

                List<Resource> resList = this.index.get(key);
                resList.add(res);

                this.index.replace(key, resList);

            // If Key is not contained in the Index
            } else {

                List<Resource> resList = new ArrayList<>();
                resList.add(res);

                this.index.put(key, resList);
            }

        }
    }

    public List<Resource> getResources(String keyword) throws NullPointerException, IllegalArgumentException {

        if (keyword == null) {
            throw new NullPointerException("Keyword cant be NULL!");
        }
        if (keyword.isEmpty()) {
            throw new IllegalArgumentException("Keyword cant be empty!");
        }

        if (this.index.containsKey(keyword)) {

            return this.index.get(keyword);

        } else {

            return new ArrayList<>();
        }
    }
}
