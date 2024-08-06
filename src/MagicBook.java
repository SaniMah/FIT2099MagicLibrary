public class MagicBook {
    private String id;
    private String title;
    private String author;

    public MagicBook(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Title: %s, Author: %s", id, title, author);
    }
}
