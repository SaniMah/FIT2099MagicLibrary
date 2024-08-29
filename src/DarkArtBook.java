import java.util.List;

public class DarkArtBook extends MagicBook{
    private int darkMagicPoint;
    private Status status;

    public DarkArtBook(String id, String title, String author, int darkMagicPoint) {
        super(id, title, author);
        this.darkMagicPoint = darkMagicPoint;
        this.status = Status.CURSED;
    }


    @Override
    public void read(User user) {
        user.addDarkMagicPoint(this.darkMagicPoint);
        user.addCapability(this.status);
    }

    @Override
    public void borrow(User user) {
        user.addDarkMagicPoint(this.darkMagicPoint);
        System.out.println("User has borrowed " + this.getTitle() + " for several days, and has returned it back to Magic Library.");
    }



    @Override
    public List<Action> allowableActions() {
        return List.of();
    }

    @Override
    public String speak() {
        return "";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Dark Magic Point: %d", darkMagicPoint);
    }
}

