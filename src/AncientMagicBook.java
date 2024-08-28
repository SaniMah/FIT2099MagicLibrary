import java.util.List;


public class AncientMagicBook extends MagicBook {
    private final int magicPoint;
    private final Status status;

    public AncientMagicBook(String author, String title, int magicPoint) {
        super(Utility.generateRandomInt(1, 100), author, title); // Assuming Utility has the correct generateRandomInt method
        this.magicPoint = magicPoint;
        this.status = Status.ANCIENT_WISDOM;
    }

    @Override
    public void read(User user) {
        if (user.hasCapability(Status.CURSED)) {
            user.removeCapability(Status.CURSED);
            user.addCapability(this.status);
            user.deductDarkMagicPoint(this.magicPoint);
            System.out.println("I am feeling much better!");
        } else {
            user.addMagicPoint(this.magicPoint * 2);
            System.out.println("After reading the ancient magic books, I can now understand more!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Magic Point: %d", magicPoint);
    }

    @Override
    public List<Action> allowableActions() {
        // Implement or return actions relevant to this book
        return List.of(new ReadAction(this));
    }
}
