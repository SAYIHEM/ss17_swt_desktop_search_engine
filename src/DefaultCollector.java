import java.util.Set;
import java.util.TreeSet;

public class DefaultCollector implements KeywordCollector {

    @Override
    public Set<String> getKeywords(Resource res) throws NullPointerException {

        if (res == null) {
            throw new NullPointerException("Resource to get filename cant be NULL!");
        }

        TreeSet<String> filename = new TreeSet<>();
        filename.add(res.getName());

        return filename;
    }
}
