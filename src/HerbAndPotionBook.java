import java.util.List;

public class HerbAndPotionBook extends MagicBook implements Borrowable {
    private int magicPoint;

    public HerbAndPotionBook(String id, String title, String author, int magicPoint) {
        super(String.valueOf(Utility.generateRandomInt(100, 200)), title, author);
        this.magicPoint = magicPoint;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Magic Point: %d", magicPoint);
    }

    @Override
    public void read(User user) {
        user.addMagicPoint(this.magicPoint);
        System.out.println("User has read " + this.getTitle() + " and gained " + this.magicPoint + " magic points.");
    }

    @Override
    public void borrow(User user) {
        user.addMagicPoint(this.magicPoint);
        System.out.println("User has borrowed " + this.getTitle() + " for several days, and has returned it back to Magic Library.");
    }

    @Override
    public List<Action> allowableActions() {
        // Return the actions that are allowed for this book (reading and borrowing)
        return List.of(new ReadAction(this), new BorrowAction(this));
    }

    @Override
    public String speak() {
        return "";
    }
}
