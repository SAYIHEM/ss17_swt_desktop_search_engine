import java.util.Iterator;
import java.util.NoSuchElementException;

public class TextFileIterator implements Iterator<String> {

    private Resource resource;
    private String[] splittedString;
    private int iterator = 0;

    public TextFileIterator(Resource res) throws NullPointerException  {

        if (res == null) {
            throw new NullPointerException("Resource cant be NULL!");
        }

        this.resource = res;

        // Split String into words
        splittedString = this.splitString(this.getAsString(this.resource));
    }

    @Override
    public boolean hasNext() {

        return this.iterator < this.splittedString.length;
    }

    @Override
    public String next() throws NoSuchElementException{

        if (hasNext()) {

            String s = splittedString[this.iterator];
            this.iterator++;

            return s;

        } else {

            throw new NoSuchElementException("No more words in resource!");
        }

    }

    @Override
    public void remove() throws UnsupportedOperationException {

        throw new UnsupportedOperationException("Operation not supported!");
    }

    public String getAsString(Resource res) throws NullPointerException {

        if (res == null) {
            throw new NullPointerException("Resource cant be NULL!");
        }

        return "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";
    }

    private String[] splitString(String s) {

        s = s.replace("-\n", "");
        s = s.replace("\n", " ");

        s = s.replaceAll("[-+.^:,!?]","");

        return s.split(" |[\\n]");
    }
}
