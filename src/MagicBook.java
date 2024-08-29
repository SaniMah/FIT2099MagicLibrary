import java.util.List;

public abstract class MagicBook implements ActionCapable {

    private final String id;
    private final String title;
    private final String author;

    public MagicBook(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Title: %s, Author: %s", id, title, author);
    }

    // Abstract methods to be implemented by subclasses
    public abstract void read(User user);

    public abstract void borrow(User user);

    public abstract List<Action> allowableActions();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getID() {
        return id;
    }
}
