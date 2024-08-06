public class DarkArtBook extends MagicBook {
    private int darkMagicPoint;

    public DarkArtBook(String id, String title, String author, int darkMagicPoint) {
        super(id, title, author);
        this.darkMagicPoint = darkMagicPoint;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Dark Magic Point: %d", darkMagicPoint);
    }
}

