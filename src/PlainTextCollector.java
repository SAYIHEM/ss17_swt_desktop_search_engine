import java.util.Set;
import java.util.TreeSet;

public class PlainTextCollector implements KeywordCollector {

    public PlainTextCollector() {

    }

    @Override
    public Set<String> getKeywords(Resource res) {

        TextFileIterator fileIterator = new TextFileIterator(res);
        Set<String> stringSet = new TreeSet<>();

        if (res.getType().getDescription().equals("unknown")) {

            DefaultCollector defaultCollector = new DefaultCollector();
            return defaultCollector.getKeywords(res);
        }

        while (fileIterator.hasNext()) {

            stringSet.add(fileIterator.next());
        }

        return stringSet;
    }
}
