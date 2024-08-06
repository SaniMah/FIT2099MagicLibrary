public class AncientMagicBook extends MagicBook {
    private int magicPoint;

    public AncientMagicBook(String id, String title, String author, int magicPoint) {
        super(id, title, author);
        this.magicPoint = magicPoint;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Magic Point: %d", magicPoint);
    }
}

