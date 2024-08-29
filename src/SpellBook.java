import java.util.List;

public class SpellBook extends MagicBook implements Borrowable {
    private int magicPoint;

    public SpellBook(String id, String title, String author, int magicPoint) {
        super(id, title, author);
        this.magicPoint = magicPoint;
    }

    @Override
    public void read(User user) {
        user.addMagicPoint(magicPoint);
        System.out.println("User now has Magic power of " + user.getMagicPoint() + " and Dark magic power of " + user.getDarkMagicPoint());
    }

    @Override
    public void borrow(User user) {
        user.addMagicPoint(magicPoint);
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

    @Override
    public String toString() {
        return super.toString() + " | Magic Point: " + magicPoint;
    }
}
